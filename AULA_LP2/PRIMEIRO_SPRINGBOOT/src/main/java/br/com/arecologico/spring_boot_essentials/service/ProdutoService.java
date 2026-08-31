package br.com.arecologico.spring_boot_essentials.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.arecologico.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.arecologico.spring_boot_essentials.dto.ProdutoDto;
import br.com.arecologico.spring_boot_essentials.exception.NotFoundException;

@Service
public class ProdutoService {

    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();

    static {
        PRODUTOS.add(ProdutoEntity.builder()
            .id(1)
            .nome("Notebook")
            .preco(new BigDecimal(5000))
            .quantidade(10)
            .build());
        PRODUTOS.add(ProdutoEntity.builder()
            .id(2)
            .nome("Iphone")
            .preco(new BigDecimal(7000))
            .quantidade(10)
            .build());
        PRODUTOS.add(ProdutoEntity.builder()
            .id(3)
            .nome("Mouse")
            .preco(new BigDecimal(500))
            .quantidade(10)
            .build());
    }

    // GET
    public List<ProdutoEntity> findAll() {
        return new ArrayList<>(PRODUTOS);
    }

    // POST
    public ProdutoEntity createProduct(ProdutoDto produtoDto) {
        Integer identificador = PRODUTOS.stream()
            .mapToInt(ProdutoEntity::getId)
            .max()
            .orElse(0) + 1;

        ProdutoEntity novoProduto = ProdutoEntity.builder()
            .id(identificador)
            .nome(produtoDto.getNome())
            .preco(produtoDto.getPreco())
            .quantidade(produtoDto.getQuantidade())
            .build();

        PRODUTOS.add(novoProduto);

        return novoProduto;
    }

    // PUT
    public ProdutoEntity updateProduct(ProdutoDto produtoDto, Integer id) throws NotFoundException {
        ProdutoEntity produto = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(() ->  new NotFoundException("Produto não encontrado"));
        
        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade());

        return produto;
    }

    // DELETE
    public void deleteProduct( Integer id) {
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }

}
