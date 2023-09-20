package com.pizzaria.pizzaria_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pizzaria.pizzaria_api.entity.Tamanho;
import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProdutoDTO {
    private Long id;
    private String nome;
    private Tamanho tamanho;
    private double valor;
    private String observacao;
    private List<SaborDTO> sabores;
    @JsonIgnore
    private List<PedidoDTO> pedidos;
}
