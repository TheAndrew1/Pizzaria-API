package com.pizzaria.pizzaria_api.Repository;

import com.pizzaria.pizzaria_api.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
