package entities;

import java.time.LocalDateTime;

public class AdminEntity extends PessoaEntity {
    private LocalDateTime dataCadastro;

    public AdminEntity() {
        super();
        dataCadastro = LocalDateTime.now();
    }

    public AdminEntity(String cpf, String nome, String senha, StatusEntity status, LocalDateTime dataCadastro) {
        super(cpf, nome, senha, status);
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String mostrarStatus() {
        return "Administrador: " + getNome() + " - Status: " + getStatus().getDescricao();
    }
}
