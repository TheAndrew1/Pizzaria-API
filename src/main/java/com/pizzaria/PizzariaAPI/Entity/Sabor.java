package com.pizzaria.PizzariaAPI.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_sabor", schema = "public")
@Data
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
    @JsonBackReference
    private List<Produto> produtos;
}
