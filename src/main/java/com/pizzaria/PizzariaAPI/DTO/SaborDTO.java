package com.pizzaria.PizzariaAPI.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SaborDTO {
    private Long id;

    private String nome;

    private String descricao;

    private String observacao;

    private double valor;

    private List<ProdutoDTO> produtos;

    public SaborDTO() {
    }

    public SaborDTO(String nome, String descricao, String observacao, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.observacao = observacao;
        this.valor = valor;
    }
}
