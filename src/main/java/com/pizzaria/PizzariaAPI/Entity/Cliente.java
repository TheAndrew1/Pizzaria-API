package com.pizzaria.PizzariaAPI.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_cliente", schema = "public")
@Getter @Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int idade;

    private String email;

    private String senha;

    @OneToMany
    @JoinColumn(name = "id")
    @JsonBackReference
    private List<Pedido> pedidos;

    @ManyToMany
    @JoinColumn(name = "id_endereco")
    private List<Endereco> enderecos;

    public Cliente(){}

    public Cliente(String nome, int idade, String email, String senha){
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
    }
}
