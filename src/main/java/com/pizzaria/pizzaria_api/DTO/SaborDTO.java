package com.pizzaria.pizzaria_api.DTO;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SaborDTO {
    private Long id;
    private String nome;
    private String descricao;
    private double valor;
    @JsonIgnore
    private List<ProdutoDTO> produtos;
}
