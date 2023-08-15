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

    private ClienteDTO cliente;

    private EnderecoDTO endereco;

    private FuncionarioDTO funcionario;

    private List<ProdutoDTO> produtos;

    public PedidoDTO(){}

    public PedidoDTO(Long id, Date data, boolean entrega, Situacao situacao, boolean pagamento, double valor){
        this.id = id;
        this.data = data;
        this.entrega = entrega;
        this.situacao = situacao;
        this.pagamento = pagamento;
        this.valor = valor;
    }

    public PedidoDTO(Long id, Date data, boolean entrega, Situacao situacao, boolean pagamento, double valor, ClienteDTO cliente, EnderecoDTO endereco, FuncionarioDTO funcionario){
        this.id = id;
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
