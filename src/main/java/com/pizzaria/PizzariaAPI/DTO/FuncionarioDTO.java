package com.pizzaria.PizzariaAPI.DTO;

import com.pizzaria.PizzariaAPI.Entity.Pedido;
import lombok.Data;

import java.util.List;

@Data
public class FuncionarioDTO {
    private Long id;

    private String nome;

    private String login;

    private String senha;

    //private List<PedidoDTO> pedidos;
}
