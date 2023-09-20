package com.pizzaria.pizzaria_api.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EnderecoDTO {
    private Long id;
    private String bairro;
    private String rua;
    private int numero;
    @JsonIgnore
    private ClienteDTO cliente;
    @JsonIgnore
    private List<PedidoDTO> pedidos;
}
