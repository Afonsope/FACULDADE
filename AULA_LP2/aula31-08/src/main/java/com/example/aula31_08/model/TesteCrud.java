package com.example.aula31_08.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_teste_crud")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TesteCrud {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpessoa")
    private TestePessoa pessoa;

    @Column(name = "preco")
    private Float preco;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "nome")
    private String nome;

    @Column(name = "estoque")
    private Integer estoque;
}