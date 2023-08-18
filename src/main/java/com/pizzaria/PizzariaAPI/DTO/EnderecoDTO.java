package com.pizzaria.PizzariaAPI.DTO;

import lombok.Data;

@Data
public class EnderecoDTO {
    private Long id;

    private String bairro;

    private String rua;

    private int numero;

    //private int id_cliente;
}
