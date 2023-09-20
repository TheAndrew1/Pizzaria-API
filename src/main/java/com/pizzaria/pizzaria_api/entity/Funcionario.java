package com.pizzaria.pizzaria_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_funcionario", schema = "public")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Column(name = "login", nullable = false, length = 25)
    private String login;
    @Column(name = "senha", nullable = false, length = 20)
    private String senha;
    @OneToMany(mappedBy = "funcionario")
    private List<Pedido> pedidos;
}
