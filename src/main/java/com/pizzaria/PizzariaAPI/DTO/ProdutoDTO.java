package com.pizzaria.PizzariaAPI.DTO;

import com.pizzaria.PizzariaAPI.Entity.Tamanho;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProdutoDTO {
    private Long id;

    private String nome;

    private Tamanho tamanho;

    private double valor;

    private List<SaborDTO> sabores;

    private List<PedidoDTO> pedidos;

    public ProdutoDTO(){}

    public ProdutoDTO(String nome, Tamanho tamanho, double valor){
        this.nome = nome;
        this.tamanho = tamanho;
        this.valor = valor;
    }
}
