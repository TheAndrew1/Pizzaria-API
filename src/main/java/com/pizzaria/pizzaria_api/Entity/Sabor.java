package com.pizzaria.pizzaria_api.Entity;

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
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "nome", nullable = false, unique = true, length = 50)
    private String nome;
    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;
    @Column(name = "valor", nullable = false)
    private double valor;
    @ManyToMany(mappedBy = "sabores")
    private List<Produto> produtos;
}