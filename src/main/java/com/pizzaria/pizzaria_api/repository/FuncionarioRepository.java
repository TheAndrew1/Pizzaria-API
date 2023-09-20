package com.pizzaria.pizzaria_api.repository;

import com.pizzaria.pizzaria_api.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
