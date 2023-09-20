package com.pizzaria.pizzaria_api.repository;

import com.pizzaria.pizzaria_api.entity.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaborRepository extends JpaRepository<Sabor, Long> {
}
