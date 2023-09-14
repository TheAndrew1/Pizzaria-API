package com.pizzaria.PizzariaAPI.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_sabor", schema = "public")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Sabor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String observacao;
    private double valor;
    @ManyToMany
    @JoinTable(
            name = "tb_produto_sabor",
            joinColumns = @JoinColumn(name = "id_sabor", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id")
    )
    private List<Produto> produtos;
}