package com.pizzaria.pizzaria_api.testes.controller;


import com.pizzaria.pizzaria_api.controller.EnderecoController;
import com.pizzaria.pizzaria_api.dto.EnderecoDTO;
import com.pizzaria.pizzaria_api.entity.Endereco;
import com.pizzaria.pizzaria_api.repository.EnderecoRepository;
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
class EnderecoControllerTest {
    @Autowired
    EnderecoController enderecoController;
    @MockBean
    EnderecoRepository enderecoRepository;

    @BeforeEach
    void injectData(){
        Endereco endereco1 = new Endereco(1L, "Vila A", "Av Silvio Americo", 3363, null, null);
        Endereco endereco2 = new Endereco(2L, "Centro", "Rua Marechal Floriano", 56, null, null);
        Endereco endereco3 = new Endereco(3L, "Parque Presidente", "Rua das Rosas", 312, null, null);
        List<Endereco> enderecos = List.of(endereco1, endereco2, endereco3);

        Mockito.when(enderecoRepository.findById(1L)).thenReturn(Optional.of(endereco1));
        Mockito.when(enderecoRepository.findAll()).thenReturn(enderecos);
        Mockito.when(enderecoRepository.save(endereco1)).thenReturn(endereco1);
    }

    @Test
    void TestControllerFindById01(){    //Certo
        var resposta = enderecoController.findById(1L);
        Long id = resposta.getBody().getId();
        String bairro = resposta.getBody().getBairro();
        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(1L, id);
        Assertions.assertEquals("Vila A", bairro);
    }

    @Test
    void TestControllerFindById02(){    //Falha
        var resposta = enderecoController.findById(2L);
        Long id = resposta.getBody().getId();
        String bairro = resposta.getBody().getBairro();
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertNull(id);
        Assertions.assertNull(bairro);
    }

    @Test
    void TestControllerFindByAll(){
        var resposta = enderecoController.findAll();
        int quantidade = resposta.getBody().size();

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(3, quantidade);
    }

    @Test
    void TestControllerCreate01(){  //Certo
        EnderecoDTO enderecoCriado = new EnderecoDTO(1L, "Vila A", "Av Silvio Americo", 3363, null, null);
        String mensagem = "Cadastrado com sucesso!";

        var resposta = enderecoController.create(enderecoCriado);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerCreate02(){  //Falha
        EnderecoDTO enderecoCriado = new EnderecoDTO(1L, "Vila A", "Av Silvio Americo", 0, null, null);
        String mensagem = "Número da residência não pode ser negativa!";

        var resposta = enderecoController.create(enderecoCriado);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerUpdate01(){  //Certo
        EnderecoDTO enderecoEditado = new EnderecoDTO(1L, "Vila A", "Av Silvio Americo Sasdelli", 3363, null, null);
        String mensagem = "Editado com sucesso!";

        var resposta = enderecoController.update(1L, enderecoEditado);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerUpdate02(){  //Falha
        EnderecoDTO enderecoEditado = new EnderecoDTO(1L, "Vila A", "", 3363, null, null);
        String mensagem = "Rua inválida!";

        var resposta = enderecoController.update(1L, enderecoEditado);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerDelete01(){  //Certo
        String mensagem = "Exlcuido com sucesso!";

        var resposta = enderecoController.delete(1L);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerDelete02(){  //Falha
        String mensagem = "No value present";

        var resposta = enderecoController.delete(2L);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }
}
