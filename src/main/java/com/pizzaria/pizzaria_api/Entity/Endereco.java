package com.pizzaria.pizzaria_api.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_endereco", schema = "public")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "bairro", nullable = false, length = 40)
    private String bairro;
    @Column(name = "rua", nullable = false, length = 40)
    private String rua;
    @Column(name = "numero", nullable = false)
    private int numero;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @OneToMany(mappedBy = "endereco")
    private List<Pedido> pedidos;
}
