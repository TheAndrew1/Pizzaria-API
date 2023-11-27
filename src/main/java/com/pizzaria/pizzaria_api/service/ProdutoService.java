package com.pizzaria.pizzaria_api.service;

import com.pizzaria.pizzaria_api.convert.ProdutoConverter;
import com.pizzaria.pizzaria_api.dto.ProdutoDTO;
import com.pizzaria.pizzaria_api.dto.SaborDTO;
import com.pizzaria.pizzaria_api.entity.Produto;
import com.pizzaria.pizzaria_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoConverter produtoConverter;

    public ProdutoDTO findById(Long id) {
        return produtoConverter.convertToProdutoDTO(this.produtoRepository.findById(id).orElseThrow());
    }

    public List<ProdutoDTO> findAll() {
        List<Produto> produtos = this.produtoRepository.findAll();

        return produtos.stream().map(item -> produtoConverter.convertToProdutoDTO(item)).toList();
    }

    @Transactional(rollbackFor = Exception.class)
    public ProdutoDTO create(final ProdutoDTO produtoDTO) {
        Assert.isTrue(!produtoDTO.getNome().isBlank(), "Deve conter nome do produto!");
        Assert.isTrue(produtoDTO.getValor() >= 0, "Valor deve ser positivo!");

        validarTamanhoSabores(produtoDTO);

        Produto produto = produtoConverter.convertToProduto(produtoDTO);
        return produtoConverter.convertToProdutoDTO(this.produtoRepository.save(produto));
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Long id, ProdutoDTO produtoDTO) {
        ProdutoDTO produtoDatabase = findById(id);
        Assert.notNull(produtoDatabase, "Produto não encontrado!");
        Assert.isTrue(produtoDatabase.getId().equals(produtoDTO.getId()), "Produtos não conferem!");

        Assert.isTrue(!produtoDTO.getNome().isBlank(), "Deve conter nome do produto!");
        Assert.isTrue(produtoDTO.getValor() >= 0, "Valor deve ser positivo!");

        validarTamanhoSabores(produtoDTO);

        Produto produto = produtoConverter.convertToProduto(produtoDTO);
        this.produtoRepository.save(produto);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Produto produto = produtoConverter.convertToProduto(findById(id));
        this.produtoRepository.delete(produto);
    }

    public void validarTamanhoSabores(ProdutoDTO produtoDTO){
        if (produtoDTO.getTamanho() != null){
            Assert.isTrue(produtoDTO.getTamanho().getQuantidadeSabores() >= produtoDTO.getSabores().size(), "Quantidade de sabores não condiz coom o tamanho da pizza!");
            produtoDTO.setValor(calcularPreco(produtoDTO));
        }else {
            Assert.isTrue(produtoDTO.getSabores() == null || produtoDTO.getSabores().size() == 0, "Apenas pizzas devem conter sabores!");
            Assert.isTrue(produtoDTO.getValor() != 0, "Preço do produto não pode ser zero!");
        }
    }

    public double calcularPreco(ProdutoDTO produtoDTO) {
        double preco = 0;
        for(SaborDTO saborDTO : produtoDTO.getSabores()){
            preco += saborDTO.getValor();
        }
        return preco;
    }
}
