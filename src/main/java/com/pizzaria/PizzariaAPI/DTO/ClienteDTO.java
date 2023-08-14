package com.pizzaria.PizzariaAPI.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ClienteDTO {
    private Long id;

    private String nome;

    private int idade;

    private String email;

    private String senha;

    private List<PedidoDTO> pedidos;

    private List<EnderecoDTO> enderecos;

    public ClienteDTO(){}

    public ClienteDTO(String nome, int idade, String email, String senha){
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
    }
}
