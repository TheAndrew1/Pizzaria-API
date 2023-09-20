package com.pizzaria.pizzaria_api.repository;

import com.pizzaria.pizzaria_api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
