package com.pizzaria.PizzariaAPI.DTO;

import com.pizzaria.PizzariaAPI.Entity.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class PedidoDTO {
    private Long id;

    private Date data;

    private boolean entrega;

    private Situacao situacao;

    private boolean pagamento;

    private double valor;

    private Cliente cliente;

    private Endereco endereco;

    private Funcionario funcionario;

    private List<ProdutoDTO> produtos;

    public PedidoDTO(){}

    public PedidoDTO(Date data, boolean entrega, Situacao situacao, boolean pagamento, double valor, Cliente cliente, Endereco endereco, Funcionario funcionario){
        this.data = data;
        this.entrega = entrega;
        this.situacao = situacao;
        this.pagamento = pagamento;
        this.valor = valor;
        this.cliente = cliente;
        this.endereco = endereco;
        this.funcionario = funcionario;
    }
}
