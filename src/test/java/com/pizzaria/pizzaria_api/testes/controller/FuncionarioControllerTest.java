package com.pizzaria.pizzaria_api.testes.controller;

import com.pizzaria.pizzaria_api.controller.FuncionarioController;
import com.pizzaria.pizzaria_api.dto.FuncionarioDTO;
import com.pizzaria.pizzaria_api.entity.Funcionario;
import com.pizzaria.pizzaria_api.repository.FuncionarioRepository;
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
class FuncionarioControllerTest {
    @Autowired
    FuncionarioController funcionarioController;
    @MockBean
    FuncionarioRepository funcionarioRepository;

    @BeforeEach
    void injectData(){
        Funcionario funcionario1 = new Funcionario(1L, "Andre", "andre@email.com", "andre123", "ADMIN", null);
        Funcionario funcionario2 = new Funcionario(2L, "Julia", "julia@email.com", "julia123", "ADMIN", null);
        Funcionario funcionario3 = new Funcionario(3L, "Cleyton", "cleyton@email.com", "cleyton123", "ADMIN", null);
        List<Funcionario> funcionarios = List.of(funcionario1, funcionario2, funcionario3);

        Mockito.when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario1));
        Mockito.when(funcionarioRepository.findAll()).thenReturn(funcionarios);
        Mockito.when(funcionarioRepository.save(funcionario1)).thenReturn(funcionario1);
    }

    @Test
    void TestControllerFindById01(){    //Certo
        var resposta = funcionarioController.findById(1L);
        Long id = resposta.getBody().getId();
        String nome = resposta.getBody().getNome();
        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(1L, id);
        Assertions.assertEquals("Andre", nome);
    }

    @Test
    void TestControllerFindById02(){    //Falha
        var resposta = funcionarioController.findById(2L);
        Long id = resposta.getBody().getId();
        String nome = resposta.getBody().getNome();
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertNull(id);
        Assertions.assertNull(nome);
    }

    @Test
    void TestControllerFindByAll(){
        var resposta = funcionarioController.findAll();
        int quantidade = resposta.getBody().size();

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(3, quantidade);
    }

    @Test
    void TestControllerCreate01(){  //Certo
        FuncionarioDTO funcionarioCriado = new FuncionarioDTO(1L, "Andre", "andre@email.com", "andre123", "ADMIN");
        String mensagem = "Cadastrado com sucesso!";

        var resposta = funcionarioController.create(funcionarioCriado);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerCreate02(){  //Falha
        FuncionarioDTO funcionarioCriado = new FuncionarioDTO(1L, "Andre", "andre@email.com", "", "ADMIN");
        String mensagem = "Senha inválido!";

        var resposta = funcionarioController.create(funcionarioCriado);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerUpdate01(){  //Certo
        FuncionarioDTO funcionarioEditado = new FuncionarioDTO(1L, "Andre", "andre@gmail.com", "andre123", "ADMIN");
        String mensagem = "Editado com sucesso!";

        var resposta = funcionarioController.update(1L, funcionarioEditado);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerUpdate02(){  //Falha
        FuncionarioDTO funcionarioEditado = new FuncionarioDTO(1L, "", "andre@email.com", "andre123", "ADMIN");
        String mensagem = "Nome inválido!";

        var resposta = funcionarioController.update(1L, funcionarioEditado);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerDelete01(){  //Certo
        String mensagem = "Exlcuido com sucesso!";

        var resposta = funcionarioController.delete(1L);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerDelete02(){  //Falha
        String mensagem = "No value present";

        var resposta = funcionarioController.delete(2L);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }
}
