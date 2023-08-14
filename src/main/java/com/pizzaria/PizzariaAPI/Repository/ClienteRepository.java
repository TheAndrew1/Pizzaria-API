package com.pizzaria.PizzariaAPI.Repository;

import com.pizzaria.PizzariaAPI.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
