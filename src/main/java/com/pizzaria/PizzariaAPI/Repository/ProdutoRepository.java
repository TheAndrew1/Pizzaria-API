package com.pizzaria.PizzariaAPI.Repository;

import com.pizzaria.PizzariaAPI.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
