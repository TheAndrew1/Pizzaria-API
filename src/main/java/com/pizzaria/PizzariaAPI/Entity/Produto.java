package com.pizzaria.PizzariaAPI.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_produto", schema = "public")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(value = EnumType.ORDINAL)
    private Tamanho tamanho;
    private double valor;
    @ManyToMany
    @JoinTable(
            name = "tb_produto_sabor",
            joinColumns = @JoinColumn(name = "id_produto"),
            inverseJoinColumns = @JoinColumn(name = "id_sabor")
    )
    private List<Sabor> sabores;
    @ManyToMany
    @JoinTable(
            name = "tb_pedido_produto",
            joinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_pedido", referencedColumnName = "id")
    )
    private List<Pedido> pedidos;
}
