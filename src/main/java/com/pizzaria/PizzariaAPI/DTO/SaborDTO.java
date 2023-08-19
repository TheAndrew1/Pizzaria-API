package com.pizzaria.PizzariaAPI.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class SaborDTO {
    private Long id;

    private String nome;

    private String descricao;

    private String observacao;

    private double valor;

    @JsonIgnore
    private List<ProdutoDTO> produtos;
}
