package com.pizzaria.PizzariaAPI.DTO;

import com.pizzaria.PizzariaAPI.Entity.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class PedidoDTO {
    private Long id;
    private LocalDate data;
    private boolean entrega;
    private Situacao situacao;
    private Pagamento pagamento;
    private double valor;
    private ClienteDTO cliente;
    private EnderecoDTO endereco;
    private FuncionarioDTO funcionario;
    private List<ProdutoDTO> produtos;
}
