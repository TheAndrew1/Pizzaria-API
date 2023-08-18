package com.pizzaria.PizzariaAPI.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class EnderecoDTO {
    private Long id;

    private String bairro;

    private String rua;

    private int numero;

    //private List<PedidoDTO> pedidos;

    @JsonBackReference
    @JsonAlias(value = "cliente")
    private ClienteDTO clienteDTO;
}
