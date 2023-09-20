package com.pizzaria.pizzaria_api.convert;

import com.pizzaria.pizzaria_api.dto.ProdutoDTO;
import com.pizzaria.pizzaria_api.entity.Produto;
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
