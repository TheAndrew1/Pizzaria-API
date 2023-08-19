package com.pizzaria.PizzariaAPI.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_produto", schema = "public")
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(value = EnumType.ORDINAL)
    private Tamanho tamanho;

    private double valor;

    @ManyToMany(mappedBy = "produtos")
    @JoinColumn(name = "id_sabor")
    @JsonManagedReference
    private List<Sabor> sabores;

    @ManyToMany(mappedBy = "produtos")
    @JsonBackReference
    private List<Pedido> pedidos;
}
