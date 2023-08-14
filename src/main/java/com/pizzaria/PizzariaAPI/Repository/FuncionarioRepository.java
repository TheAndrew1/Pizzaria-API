package com.pizzaria.PizzariaAPI.Repository;

import com.pizzaria.PizzariaAPI.Entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
