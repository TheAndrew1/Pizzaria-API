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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tb_produto_sabor",
            joinColumns = @JoinColumn(name = "id_sabor", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id")
    )
    @JsonBackReference
    private List<Produto> produtos;
}