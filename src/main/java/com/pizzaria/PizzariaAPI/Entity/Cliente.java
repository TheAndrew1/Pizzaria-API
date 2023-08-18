package com.pizzaria.PizzariaAPI.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_cliente", schema = "public")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int idade;

    private String email;

    private String senha;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Pedido> pedidos;
}
