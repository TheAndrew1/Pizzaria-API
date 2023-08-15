package com.pizzaria.PizzariaAPI.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_funcionario", schema = "public")
@Getter @Setter
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String login;

    private String senha;

    @OneToMany
    @JoinColumn(name = "id")
    @JsonBackReference
    private List<Pedido> pedidos;

    public Funcionario(){}

    public Funcionario(Long id, String nome, String login, String senha){
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
}
