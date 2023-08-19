package com.pizzaria.PizzariaAPI.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.List;

@Data
public class SaborDTO {
    private Long id;

    private String nome;

    private String descricao;

    private String observacao;

    private double valor;

    @JsonBackReference
    private List<ProdutoDTO> produtos;
}
