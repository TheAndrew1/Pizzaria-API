package com.pizzaria.PizzariaAPI.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {
    private Long id;

    private String nome;

    private int idade;

    private String email;

    private String senha;

    //private List<PedidoDTO> pedidos;

    private List<EnderecoDTO> enderecos;
}
