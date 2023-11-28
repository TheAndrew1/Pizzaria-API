package com.pizzaria.pizzaria_api.repository;

import com.pizzaria.pizzaria_api.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Funcionario, Long> {

	public Optional<Funcionario> findByUsername(String login);
	
}
