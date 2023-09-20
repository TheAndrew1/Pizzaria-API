package com.pizzaria.pizzaria_api.repository;

import com.pizzaria.pizzaria_api.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
