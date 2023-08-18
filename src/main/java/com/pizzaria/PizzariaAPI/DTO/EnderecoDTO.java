package com.pizzaria.PizzariaAPI.DTO;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.List;

@Data
public class EnderecoDTO {
    private Long id;

    private String bairro;

    private String rua;

    private int numero;

    @JsonIgnore
    private List<PedidoDTO> pedidos;

    @JsonBackReference
    @JsonAlias(value = "cliente")
    private ClienteDTO clienteDTO;
}
