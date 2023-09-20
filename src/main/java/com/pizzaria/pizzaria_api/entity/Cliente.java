package com.pizzaria.pizzaria_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_cliente", schema = "public")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Column(name = "idade", nullable = false)
    private int idade;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "senha", nullable = false, length = 20)
    private String senha;
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
}
