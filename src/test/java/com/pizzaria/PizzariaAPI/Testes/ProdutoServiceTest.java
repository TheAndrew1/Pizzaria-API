package com.pizzaria.PizzariaAPI.Testes;

import com.pizzaria.PizzariaAPI.DTO.ProdutoDTO;
import com.pizzaria.PizzariaAPI.DTO.SaborDTO;
import com.pizzaria.PizzariaAPI.Entity.Tamanho;
import com.pizzaria.PizzariaAPI.Service.ProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProdutoServiceTest {
    @Autowired
    ProdutoService produtoService;

    @Test
    public void CT_Valor_01(){  //Teste calculo de valor da pizza
        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "Pizza", Tamanho.M, 0.00, null, null, null);
        produtoDTO.setSabores(List.of(new SaborDTO(1L, "Brocolis", "Queijo e brocolis", 18.00, null), new SaborDTO(2L, "Bacon", "Queijo e bacon", 15.00, null)));

        produtoDTO.setValor(produtoService.calcularPreco(produtoDTO));

        Assertions.assertEquals(33.00, produtoDTO.getValor());
    }

    @Test
    public void CT_TamanhoSabores_01(){    //Com tamanho e quantidade certa
        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "Pizza", Tamanho.M, 0.00, null, null, null);
        produtoDTO.setSabores(List.of(new SaborDTO(1L, "Brocolis", "Queijo e brocolis", 18.00, null),
                new SaborDTO(2L, "Bacon", "Queijo e bacon", 15.00, null)));

        produtoService.validarTamanhoSabores(produtoDTO);

        Assertions.assertEquals(33.00, produtoDTO.getValor());
    }

//    @Test
//    public void CT_TamanhoSabores_02(){    //Com tamanho e quantidade errada
//        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "Pizza", Tamanho.P, 0.00, null, null, null);
//        produtoDTO.setSabores(List.of(new SaborDTO(1L, "Brocolis", "Queijo e brocolis", 18.00, null), new SaborDTO(2L, "Bacon", "Queijo e bacon", 15.00, null)));
//
//        produtoService.validarTamanhoSabores(produtoDTO);
//
//        Assertions.assertEquals(33.00, produtoDTO.getValor());
//    }

    @Test
    public void CT_TamanhoSabores_02(){    //Sem tamanho e sem sabor
        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "Refrigerante", null, 8.00, null, null, null);

        produtoService.validarTamanhoSabores(produtoDTO);

        Assertions.assertEquals(8.00, produtoDTO.getValor());
    }

//    @Test
//    public void CT_TamanhoSabores_04(){    //Sem tamanho e com sabor
//        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "Refrigerante", null, 8.00, null, null, null);
//        produtoDTO.setSabores(List.of(new SaborDTO(1L, "Brocolis", "Queijo e brocolis", 18.00, null)));
//
//        produtoService.validarTamanhoSabores(produtoDTO);
//    }
}
