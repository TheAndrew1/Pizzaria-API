package com.pizzaria.PizzariaAPI.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_pedido", schema = "public")
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private boolean entrega;

    @Enumerated(value = EnumType.ORDINAL)
    private Situacao situacao;

    @Enumerated(value = EnumType.ORDINAL)
    private Pagamento pagamento;

    private double valor;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

//    @ManyToMany
//    @JoinColumn(name = "id_produto")
//    @JsonManagedReference
//    private List<Produto> produtos;
}
