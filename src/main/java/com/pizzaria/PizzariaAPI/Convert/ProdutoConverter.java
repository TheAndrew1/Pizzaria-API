package com.pizzaria.PizzariaAPI.Convert;

import com.pizzaria.PizzariaAPI.DTO.ProdutoDTO;
import com.pizzaria.PizzariaAPI.Entity.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ProdutoDTO convertToProdutoDTO(Produto produto) {
        ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
        return produtoDTO;
    }

    public Produto convertToProduto(ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        return produto;
    }
}
