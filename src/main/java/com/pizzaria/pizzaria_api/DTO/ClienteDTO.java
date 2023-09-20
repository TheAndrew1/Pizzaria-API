package com.pizzaria.pizzaria_api.DTO;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nome;
    private int idade;
    private String email;
    private String senha;
    private List<EnderecoDTO> enderecos;
    @JsonIgnore
    private List<PedidoDTO> pedidos;
}
