package com.pizzaria.PizzariaAPI.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_pedido", schema = "public")
@Getter @Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;

    private boolean entrega;

    @Enumerated(value = EnumType.STRING)
    private Situacao situacao;

    private boolean pagamento;

    private double valor;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonManagedReference
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    @JsonManagedReference
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    @JsonManagedReference
    private Funcionario funcionario;

    @ManyToMany
    @JoinColumn(name = "id_produto")
    private List<Produto> produtos;

    public Pedido(){}

    public Pedido(Long id, Date data, boolean entrega, Situacao situacao, boolean pagamento, double valor){
        this.id = id;
        this.data = data;
        this.entrega = entrega;
        this.situacao = situacao;
        this.pagamento = pagamento;
        this.valor = valor;
    }

    public Pedido(Long id, Date data, boolean entrega, Situacao situacao, boolean pagamento, double valor, Cliente cliente, Endereco endereco, Funcionario funcionario){
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
