package com.pizzaria.PizzariaAPI.Repository;

import com.pizzaria.PizzariaAPI.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
