package com.pizzaria.pizzaria_api.testes.controller;

import com.pizzaria.pizzaria_api.controller.ProdutoController;
import com.pizzaria.pizzaria_api.dto.ProdutoDTO;
import com.pizzaria.pizzaria_api.entity.Produto;
import com.pizzaria.pizzaria_api.entity.Tamanho;
import com.pizzaria.pizzaria_api.repository.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProdutoControllerTest {
    @Autowired
    ProdutoController produtoController;
    @MockBean
    ProdutoRepository produtoRepository;

    @BeforeEach
    void injectData(){
        Produto produto1 = new Produto(1L, "Refrigerante", null, 8.00, null, null, null);
        Produto produto2 = new Produto(2L, "Pizza", Tamanho.P, 0.00, null, null, null);
        Produto produto3 = new Produto(3L, "Pizza", Tamanho.G, 0.00, null, null, null);
        List<Produto> produtos = List.of(produto1, produto2, produto3);

        Mockito.when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto1));
        Mockito.when(produtoRepository.findAll()).thenReturn(produtos);
        Mockito.when(produtoRepository.save(produto1)).thenReturn(produto1);
    }

    @Test
    void TestControllerFindById01(){    //Certo
        var resposta = produtoController.findById(1L);
        Long id = resposta.getBody().getId();
        String nome = resposta.getBody().getNome();
        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(1L, id);
        Assertions.assertEquals("Refrigerante", nome);
    }

    @Test
    void TestControllerFindById02(){    //Falha
        var resposta = produtoController.findById(2L);
        Long id = resposta.getBody().getId();
        String nome = resposta.getBody().getNome();
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertNull(id);
        Assertions.assertNull(nome);
    }

    @Test
    void TestControllerFindByAll(){
        var resposta = produtoController.findAll();
        int quantidade = resposta.getBody().size();

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(3, quantidade);
    }

    @Test
    void TestControllerCreate01(){  //Certo
        ProdutoDTO produtoCriado = new ProdutoDTO(1L, "Refrigerante", null, 8.00, null, null, null);
        String mensagem = "Cadastrado com sucesso!";

        var resposta = produtoController.create(produtoCriado);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerCreate02(){  //Falha
        ProdutoDTO produtoCriado = new ProdutoDTO(1L, "Refrigerante", null, 0.00, null, null, null);
        String mensagem = "Preço do produto não pode ser zero!";

        var resposta = produtoController.create(produtoCriado);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerUpdate01(){  //Certo
        ProdutoDTO produtoEditado = new ProdutoDTO(1L, "Refrigerante", null, 10.00, null, null, null);
        String mensagem = "Editado com sucesso!";

        var resposta = produtoController.update(1L, produtoEditado);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerUpdate02(){  //Falha
        ProdutoDTO produtoEditado = new ProdutoDTO(1L, "", null, 8.00, null, null, null);
        String mensagem = "Deve conter nome do produto!";

        var resposta = produtoController.update(1L, produtoEditado);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerDelete01(){  //Certo
        String mensagem = "Exlcuido com sucesso!";

        var resposta = produtoController.delete(1L);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerDelete02(){  //Falha
        String mensagem = "No value present";

        var resposta = produtoController.delete(2L);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }
}
