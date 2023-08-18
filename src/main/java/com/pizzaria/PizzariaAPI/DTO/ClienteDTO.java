package com.pizzaria.PizzariaAPI.DTO;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {
    private Long id;

    private String nome;

    private int idade;

    private String email;

    private String senha;

    @JsonManagedReference
    private List<EnderecoDTO> enderecos;

    @JsonIgnore
    private List<PedidoDTO> pedidos;
}
