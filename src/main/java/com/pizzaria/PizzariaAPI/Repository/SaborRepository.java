package com.pizzaria.PizzariaAPI.Repository;

import com.pizzaria.PizzariaAPI.Entity.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaborRepository extends JpaRepository<Sabor, Long> {
}
