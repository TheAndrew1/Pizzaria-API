package com.pizzaria.PizzariaAPI.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pizzaria.PizzariaAPI.Entity.Tamanho;
import lombok.Data;

import java.util.List;

@Data
public class ProdutoDTO {
    private Long id;

    private String nome;

    private Tamanho tamanho;

    private double valor;

    private List<SaborDTO> sabores;

    @JsonIgnore
    private List<PedidoDTO> pedidos;
}
