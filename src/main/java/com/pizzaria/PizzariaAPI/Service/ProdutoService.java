package com.pizzaria.PizzariaAPI.Service;

import com.pizzaria.PizzariaAPI.Convert.ProdutoConverter;
import com.pizzaria.PizzariaAPI.DTO.ProdutoDTO;
import com.pizzaria.PizzariaAPI.Entity.Produto;
import com.pizzaria.PizzariaAPI.Repository.ProdutoRepository;
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
        List<ProdutoDTO> produtosDTO = new ArrayList<>();

        for (Produto produto : produtos) {
            produtosDTO.add(produtoConverter.convertToProdutoDTO(produto));
        }

        return produtosDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(ProdutoDTO produtoDTO) {
        Assert.isTrue(!produtoDTO.getNome().isBlank(), "Deve conter nome do produto!");
        Assert.isTrue(produtoDTO.getValor() > 0, "Valor deve ser positivo!");

        Produto produto = produtoConverter.convertToProduto(produtoDTO);
        this.produtoRepository.save(produto);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Long id, ProdutoDTO produtoDTO) {
        ProdutoDTO produtoDatabase = findById(id);
        Assert.notNull(produtoDatabase, "Produto não encontrado!");
        Assert.isTrue(produtoDatabase.getId().equals(produtoDTO.getId()), "Produtos não conferem!");

        Assert.isTrue(!produtoDTO.getNome().isBlank(), "Deve conter nome do produto!");
        Assert.isTrue(produtoDTO.getValor() > 0, "Valor deve ser positivo!");

        Produto produto = produtoConverter.convertToProduto(produtoDTO);
        this.produtoRepository.save(produto);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Produto produto = produtoConverter.convertToProduto(findById(id));
        this.produtoRepository.delete(produto);
    }
}
