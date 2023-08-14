package com.pizzaria.PizzariaAPI.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EnderecoDTO {
    private Long id;

    private String bairro;

    private String rua;

    private int numero;

    private List<PedidoDTO> pedidos;

    private List<ClienteDTO> clientes;

    public EnderecoDTO(){}

    public EnderecoDTO(Long id, String bairro, String rua, int numero){
        this.id = id;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }
}
