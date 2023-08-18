package com.pizzaria.PizzariaAPI.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pizzaria.PizzariaAPI.Entity.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PedidoDTO {
    private Long id;

    private Date data;

    private boolean entrega;

    private Situacao situacao;

    private Pagamento pagamento;

    private double valor;

    @JsonManagedReference
    @JsonAlias(value = "cliente")
    private ClienteDTO clienteDTO;

    @JsonManagedReference
    @JsonAlias(value = "endereco")
    private EnderecoDTO enderecoDTO;

    @JsonManagedReference
    @JsonAlias(value = "funcionario")
    private FuncionarioDTO funcionarioDTO;

    //private List<ProdutoDTO> produtos;
}
