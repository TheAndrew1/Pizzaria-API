package com.pizzaria.pizzaria_api.Repository;

import com.pizzaria.pizzaria_api.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
