package com.pizzaria.PizzariaAPI.DTO;

import com.fasterxml.jackson.annotation.*;
import com.pizzaria.PizzariaAPI.Entity.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PedidoDTO {
    private Long id;

    private LocalDate data;

    private boolean entrega;

    private Situacao situacao;

    private Pagamento pagamento;

    private double valor;

    @JsonAlias(value = "cliente")
    private ClienteDTO clienteDTO;

    @JsonAlias(value = "endereco")
    private EnderecoDTO enderecoDTO;

    @JsonAlias(value = "funcionario")
    private FuncionarioDTO funcionarioDTO;

    @JsonManagedReference
    private List<ProdutoDTO> produtos;
}
