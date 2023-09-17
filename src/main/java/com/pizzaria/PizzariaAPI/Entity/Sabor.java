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
    private double valor;
    @ManyToMany(mappedBy = "sabores")
    private List<Produto> produtos;
}