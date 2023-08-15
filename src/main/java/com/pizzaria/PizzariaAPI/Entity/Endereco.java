package com.pizzaria.PizzariaAPI.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_endereco", schema = "public")
@Getter @Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bairro;

    private String rua;

    private int numero;

    @OneToMany
    @JoinColumn(name = "id_pedido")
    @JsonBackReference
    private List<Pedido> pedidos;

    @ManyToMany
    @JoinColumn(name = "id_cliente")
    @JsonIgnore
    private List<Cliente> clientes;

    public Endereco(){}

    public Endereco(Long id, String bairro, String rua, int numero){
        this.id = id;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }
}
