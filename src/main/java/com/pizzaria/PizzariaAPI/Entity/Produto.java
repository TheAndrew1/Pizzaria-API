package com.pizzaria.PizzariaAPI.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_produto", schema = "public")
@Getter @Setter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(value = EnumType.STRING)
    private Tamanho tamanho;

    private double valor;

    @ManyToMany
    @JoinColumn(name = "id_sabor")
    private List<Sabor> sabores;

    @ManyToMany
    @JoinColumn(name = "id_pedido")
    @JsonIgnore
    private List<Pedido> pedidos;

    public Produto(){}

    public Produto(String nome, Tamanho tamanho, double valor){
        this.nome = nome;
        this.tamanho = tamanho;
        this.valor = valor;
    }
}
