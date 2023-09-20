package com.pizzaria.pizzaria_api.Entity;

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
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "tamanho")
    private Tamanho tamanho;
    @Column(name = "valor")
    private double valor;
    @Column(name = "observacao", length = 100)
    private String observacao;
    @ManyToMany
    @JoinTable(
            name = "tb_produto_sabor",
            joinColumns = @JoinColumn(name = "id_produto"),
            inverseJoinColumns = @JoinColumn(name = "id_sabor")
    )
    private List<Sabor> sabores;
    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;
}
