package com.pizzaria.PizzariaAPI.Service;

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

    public ProdutoDTO findById(Long id) {
        return toProdutoDTO(this.produtoRepository.findById(id).orElseThrow());
    }

    public List<ProdutoDTO> findAll() {
        List<Produto> produtos = this.produtoRepository.findAll();
        List<ProdutoDTO> produtosDTO = new ArrayList<>();

        for (Produto produto : produtos) {
            produtosDTO.add(toProdutoDTO(produto));
        }

        return produtosDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(ProdutoDTO produtoDTO) {
        Assert.isTrue(!produtoDTO.getNome().isBlank(), "Deve conter nome do produto!");
        Assert.notNull(produtoDTO.getValor(), "Deve conter valor do produto!");

        Produto produto = toProduto(produtoDTO);
        this.produtoRepository.save(produto);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Long id, ProdutoDTO produtoDTO) {
        ProdutoDTO produtoNoBanco = findById(id);
        Assert.notNull(produtoNoBanco, "Produto não encontrado!");
        Assert.isTrue(produtoNoBanco.getId().equals(produtoDTO.getId()), "Produtos não conferem!");

        Assert.isTrue(!produtoDTO.getNome().isBlank(), "Deve conter nome do produto!");
        Assert.notNull(produtoDTO.getValor(), "Deve conter valor do produto!");

        Produto produto = toProduto(produtoDTO);
        this.produtoRepository.save(produto);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Produto produto = toProduto(findById(id));
        this.produtoRepository.delete(produto);
    }

    public ProdutoDTO toProdutoDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO(produto.getId(), produto.getNome(), produto.getTamanho(), produto.getValor());
        return produtoDTO;
    }

    public Produto toProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO.getId(), produtoDTO.getNome(), produtoDTO.getTamanho(), produtoDTO.getValor());
        return produto;
    }
}
