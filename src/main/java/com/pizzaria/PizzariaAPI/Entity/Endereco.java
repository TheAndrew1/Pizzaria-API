package com.pizzaria.PizzariaAPI.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_endereco", schema = "public")
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bairro;

    private String rua;

    private int numero;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference
    private Cliente cliente;

    @OneToMany(mappedBy = "endereco")
    @JsonIgnore
    private List<Pedido> pedidos;
}
