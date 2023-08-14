package com.pizzaria.PizzariaAPI.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_sabor", schema = "public")
@Getter @Setter
public class Sabor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private String observacao;

    private double valor;

    @ManyToMany
    @JoinColumn(name = "id_produto")
    @JsonIgnore
    private List<Produto> produtos;

    public Sabor() {
    }

    public Sabor(String nome, String descricao, String observacao, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.observacao = observacao;
        this.valor = valor;
    }
}
