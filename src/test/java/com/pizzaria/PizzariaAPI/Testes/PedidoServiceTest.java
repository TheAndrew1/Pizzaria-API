package com.pizzaria.PizzariaAPI.Testes;

import com.pizzaria.PizzariaAPI.DTO.ClienteDTO;
import com.pizzaria.PizzariaAPI.DTO.PedidoDTO;
import com.pizzaria.PizzariaAPI.DTO.ProdutoDTO;
import com.pizzaria.PizzariaAPI.Entity.Pagamento;
import com.pizzaria.PizzariaAPI.Entity.Situacao;
import com.pizzaria.PizzariaAPI.Service.PedidoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PedidoServiceTest {
    @Autowired
    PedidoService pedidoService;

    @Test
    public void CT_Valor_01(){  //Teste calculo de valor do pedido com produto
        PedidoDTO pedidoDTO = new PedidoDTO(1L, LocalDate.now(), false, Situacao.PREPARO, Pagamento.CREDITO, 0.00, null, null, null, null);
        pedidoDTO.setProdutos(List.of(new ProdutoDTO(1L, "Refrigerante", null, 8.00, null, null, null),
                new ProdutoDTO(2L, "Esfirra", null, 12.00, null, null, null)));

        pedidoDTO.setValor(pedidoService.calcularPreco(pedidoDTO));

        Assertions.assertEquals(20.00, pedidoDTO.getValor());
    }

    @Test
    public void CT_Valor_02(){  //Teste calculo de valor do pedido sem produto
        PedidoDTO pedidoDTO = new PedidoDTO(1L, LocalDate.now(), false, Situacao.PREPARO, Pagamento.CREDITO, 0.00, null, null, null, null);

        pedidoDTO.setValor(pedidoService.calcularPreco(pedidoDTO));

        Assertions.assertEquals(0.00, pedidoDTO.getValor());
    }
}
