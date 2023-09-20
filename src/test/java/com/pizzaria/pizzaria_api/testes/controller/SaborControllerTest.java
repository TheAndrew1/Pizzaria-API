package com.pizzaria.pizzaria_api.testes.controller;

import com.pizzaria.pizzaria_api.controller.SaborController;
import com.pizzaria.pizzaria_api.dto.SaborDTO;
import com.pizzaria.pizzaria_api.entity.Sabor;
import com.pizzaria.pizzaria_api.repository.SaborRepository;
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
public class SaborControllerTest {
    @Autowired
    SaborController saborController;
    @MockBean
    SaborRepository saborRepository;

    @BeforeEach
    void injectData(){
        Sabor sabor1 = new Sabor(1L, "Brócolis", "Queijo, brócoclis e catupiri", 18.00, null);
        Sabor sabor2 = new Sabor(2L, "Bacon", "Queijo e bacon", 15.00, null);
        Sabor sabor3 = new Sabor(3L, "Calabresa", "Queijo e calabresa", 15.00, null);
        List<Sabor> sabores = List.of(sabor1, sabor2, sabor3);

        Mockito.when(saborRepository.findById(1L)).thenReturn(Optional.of(sabor1));
        Mockito.when(saborRepository.findAll()).thenReturn(sabores);
        Mockito.when(saborRepository.save(sabor1)).thenReturn(sabor1);
        Mockito.when(saborRepository.save(sabor1)).thenReturn(sabor1);
    }

    @Test
    void TestControllerFindById(){
        var resposta = saborController.findById(1L);
        Long id = resposta.getBody().getId();
        String nomeSabor = resposta.getBody().getNome();
        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(1L, id);
        Assertions.assertEquals("Brócolis", nomeSabor);
    }

    @Test
    void TestControllerFindByAll(){
        var resposta = saborController.findAll();
        int quantidade = resposta.getBody().size();

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(3, quantidade);
    }

    @Test
    void TestControllerCreate01(){  //Certo
        SaborDTO saborCriado = new SaborDTO(1L, "Brócolis", "Queijo, brócoclis e catupiri", 18.00, null);
        String mensagem = "Cadastrado com sucesso!";

        var resposta = saborController.create(saborCriado);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerCreate02(){  //Falha
        SaborDTO saborCriado = new SaborDTO(1L, "Brócolis", "Queijo, brócoclis e catupiri", 0.00, null);
        String mensagem = "Valor deve ser positivo!";

        var resposta = saborController.create(saborCriado);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerUpdate01(){  //Certo
        SaborDTO saborEditado = new SaborDTO(1L, "Brócolis", "Queijo, brócoclis e catupiri", 20.00, null);
        String mensagem = "Editado com sucesso!";

        var resposta = saborController.update(1L, saborEditado);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerUpdate02(){  //Falha
        SaborDTO saborEditado = new SaborDTO(1L, "", "Queijo, brócoclis e catupiri", 20.00, null);
        String mensagem = "Deve conter nome do sabor!";

        var resposta = saborController.update(1L, saborEditado);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerDelete01(){  //Certo
        String mensagem = "Exlcuido com sucesso!";

        var resposta = saborController.delete(1L);

        Assertions.assertEquals(HttpStatus.OK, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }

    @Test
    void TestControllerDelete02(){  //Falha
        String mensagem = "No value present";

        var resposta = saborController.delete(2L);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
        Assertions.assertEquals(mensagem, resposta.getBody());
    }
}
