package com.pizzaria.pizzaria_api.Repository;

import com.pizzaria.pizzaria_api.Entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
