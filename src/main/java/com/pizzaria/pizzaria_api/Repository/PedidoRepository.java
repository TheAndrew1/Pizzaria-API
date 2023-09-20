package com.pizzaria.pizzaria_api.Repository;

import com.pizzaria.pizzaria_api.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
