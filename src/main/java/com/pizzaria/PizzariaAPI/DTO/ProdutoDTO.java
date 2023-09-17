package com.pizzaria.PizzariaAPI.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pizzaria.PizzariaAPI.Entity.Tamanho;
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
    @JsonBackReference
    private List<PedidoDTO> pedidos;
}
