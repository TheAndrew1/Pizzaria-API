package com.pizzaria.PizzariaAPI.DTO;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.util.List;

@Data
public class FuncionarioDTO {
    private Long id;

    private String nome;

    private String login;

    private String senha;

    @JsonIgnore
    private List<PedidoDTO> pedidos;
}
