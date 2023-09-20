package com.pizzaria.pizzaria_api.repository;

import com.pizzaria.pizzaria_api.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
