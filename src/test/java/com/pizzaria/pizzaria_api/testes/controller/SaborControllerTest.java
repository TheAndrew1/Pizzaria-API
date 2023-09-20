package com.pizzaria.pizzaria_api.testes.controller;

import com.pizzaria.pizzaria_api.controller.SaborController;
import com.pizzaria.pizzaria_api.entity.Sabor;
import com.pizzaria.pizzaria_api.repository.SaborRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class SaborControllerTest {
    @Autowired
    SaborController saborController;
    @Mock
    SaborRepository saborRepository;

    @BeforeEach
    void injectData(){
        Sabor sabor1 = new Sabor(1L, "Brócolis", "Queijo, brócoclis e catupiri", 18.00, null);
        Sabor sabor2 = new Sabor(2L, "Bacon", "Queijo e bacon", 15.00, null);
        Sabor sabor3 = new Sabor(3L, "Calabresa", "Queijo e calabresa", 15.00, null);
        List<Sabor> sabores = List.of(sabor1, sabor2, sabor3);

        Mockito.when(saborRepository.findById(1L)).thenReturn(Optional.of(sabor1));
        Mockito.when(saborRepository.findAll()).thenReturn(sabores);
    }

    @Test
    void TestControllerFindById(){
        var sabor = saborController.findById(1L);
        Long id = sabor.getBody().getId();
        String nomeSabor = sabor.getBody().getNome();
        Assertions.assertEquals(1L, id);
        Assertions.assertEquals("Brócolis", nomeSabor);
    }
}
