package com.pizzaria.PizzariaAPI.DTO;

import com.pizzaria.PizzariaAPI.Entity.Pedido;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class FuncionarioDTO {
    private Long id;

    private String nome;

    private String login;

    private String senha;

    private List<PedidoDTO> pedidos;

    public FuncionarioDTO(){}

    public FuncionarioDTO(String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
}
