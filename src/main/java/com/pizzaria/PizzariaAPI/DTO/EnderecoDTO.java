package com.pizzaria.PizzariaAPI.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class EnderecoDTO {
    private Long id;

    private String bairro;

    private String rua;

    private int numero;

    @JsonBackReference
    @JsonAlias(value = "cliente")
    private ClienteDTO clienteDTO;
}
