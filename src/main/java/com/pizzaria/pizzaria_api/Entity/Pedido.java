package com.pizzaria.pizzaria_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_pedido", schema = "public")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "data", nullable = false)
    private LocalDate data;
    @Column(name = "entrega", nullable = false)
    private boolean entrega;
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "situacao", nullable = false)
    private Situacao situacao;
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "pagamento")
    private Pagamento pagamento;
    @Column(name = "valor")
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
    @ManyToMany
    @JoinTable(
            name = "tb_pedido_produto",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_produto")
    )
    private List<Produto> produtos;
}
