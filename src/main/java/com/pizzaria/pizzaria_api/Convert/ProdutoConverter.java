package com.pizzaria.pizzaria_api.Convert;

import com.pizzaria.pizzaria_api.DTO.ProdutoDTO;
import com.pizzaria.pizzaria_api.Entity.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ProdutoDTO convertToProdutoDTO(Produto produto) {
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    public Produto convertToProduto(ProdutoDTO produtoDTO) {
        return modelMapper.map(produtoDTO, Produto.class);
    }
}
