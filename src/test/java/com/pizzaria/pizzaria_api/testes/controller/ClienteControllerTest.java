package com.pizzaria.pizzaria_api.testes.controller;


import com.pizzaria.pizzaria_api.controller.ClienteController;
import com.pizzaria.pizzaria_api.dto.ClienteDTO;
import com.pizzaria.pizzaria_api.entity.Cliente;
import com.pizzaria.pizzaria_api.repository.ClienteRepository;
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
class ClienteControllerTest {
    @Autowired
    ClienteController clienteController;
    @MockBean
    ClienteRepository clienteRepository;

    @BeforeEach
    void injectData(){
        Cliente cliente1 = new Cliente(1L, "Andre", 21, "andre@email.com", "andre123", null, null);
        Cliente cliente2 = new Cliente(2L, "Julia", 22, "julia@email.com", "julia123", null, null);
        Cliente cliente3 = new Cliente(3L, "Cleyton", 25, "cleyton@email.com", "cleyton123", null, null);
        List<Cliente> clientes = List.of(cliente1, cliente2, cliente3);

        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente1));
        Mockito.when(clienteRepository.findAll()).thenReturn(clientes);
        Mockito.when(clienteRepository.save(cliente1)).thenReturn(cliente1);
    }

    @Test
    void TestControllerFindById01(){    //Certo
        var resposta = clienteController.findById(1L);
        Long id = resposta.getBody().getId();
        String nome = resposta.getBody().getNome();
        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(1L, id);
        Assertions.assertEquals("Andre", nome);
    }

    @Test
    void TestControllerFindById02(){    //Falha
        var resposta = clienteController.findById(2L);
        Long id = resposta.getBody().getId();
        String nome = resposta.getBody().getNome();
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertNull(id);
        Assertions.assertNull(nome);
    }

    @Test
    void TestControllerFindByAll(){
        var resposta = clienteController.findAll();
        int quantidade = resposta.getBody().size();

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(3, quantidade);
    }

    @Test
    void TestControllerCreate01(){  //Certo
        ClienteDTO clienteCriado = new ClienteDTO(1L, "Andre", 21, "andre@email.com", "andre1234", null, null);
        String mensagem = "Cadastrado com sucesso!";

        var resposta = clienteController.create(clienteCriado);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerCreate02(){  //Falha
        ClienteDTO clienteCriado = new ClienteDTO(1L, "Andre", 0, "andre@email.com", "andre123", null, null);
        String mensagem = "Idade deve ser maior que 0!";

        var resposta = clienteController.create(clienteCriado);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerUpdate01(){  //Certo
        ClienteDTO clienteEditado = new ClienteDTO(1L, "Andre", 21, "andre@email.com", "andre123", null, null);
        String mensagem = "Editado com sucesso!";

        var resposta = clienteController.update(1L, clienteEditado);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerUpdate02(){  //Falha
        ClienteDTO clienteEditado = new ClienteDTO(1L, "Andre", 21, "andreemail.com", "andre123", null, null);
        String mensagem = "Formato do email inválido!";

        var resposta = clienteController.update(1L, clienteEditado);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerDelete01(){  //Certo
        String mensagem = "Exlcuido com sucesso!";

        var resposta = clienteController.delete(1L);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerDelete02(){  //Falha
        String mensagem = "No value present";

        var resposta = clienteController.delete(2L);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }
}
