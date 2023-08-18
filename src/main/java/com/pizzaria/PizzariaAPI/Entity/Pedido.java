package com.pizzaria.PizzariaAPI.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_pedido", schema = "public")
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;

    private boolean entrega;

    @Enumerated(value = EnumType.STRING)
    private Situacao situacao;

    @Enumerated(value = EnumType.STRING)
    private Pagamento pagamento;

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
    @JsonManagedReference
    private List<Produto> produtos;
}
