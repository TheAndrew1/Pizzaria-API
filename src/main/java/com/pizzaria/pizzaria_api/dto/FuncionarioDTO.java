package com.pizzaria.pizzaria_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class FuncionarioDTO {
    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String role;
    private String token;
    @JsonIgnore
    private List<PedidoDTO> pedidos;
}
