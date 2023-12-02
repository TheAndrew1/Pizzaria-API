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

    public FuncionarioDTO(Long id, String nome, String login, String senha, String role){
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.role = role;
    }
}
