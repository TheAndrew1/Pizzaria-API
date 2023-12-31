package com.pizzaria.pizzaria_api.testes.service;

import com.pizzaria.pizzaria_api.dto.PedidoDTO;
import com.pizzaria.pizzaria_api.dto.ProdutoDTO;
import com.pizzaria.pizzaria_api.entity.Pagamento;
import com.pizzaria.pizzaria_api.entity.Situacao;
import com.pizzaria.pizzaria_api.service.PedidoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class PedidoServiceTest {
    @Autowired
    PedidoService pedidoService;

    @Test
    void CT_Valor_01(){  //Teste calculo de valor do pedido com produto
        PedidoDTO pedidoDTO = new PedidoDTO(1L, LocalDate.now(), false, Situacao.PREPARO, Pagamento.CREDITO, 0.00, null, null, null, null);
        pedidoDTO.setProdutos(List.of(new ProdutoDTO(1L, "Refrigerante", null, 8.00, null, null, null),
                new ProdutoDTO(2L, "Esfirra", null, 12.00, null, null, null)));

        pedidoDTO.setValor(pedidoService.calcularPreco(pedidoDTO));

        Assertions.assertEquals(20.00, pedidoDTO.getValor());
    }

    @Test
    void CT_Valor_02(){  //Teste calculo de valor do pedido sem produto
        PedidoDTO pedidoDTO = new PedidoDTO(1L, LocalDate.now(), false, Situacao.PREPARO, Pagamento.CREDITO, 0.00, null, null, null, null);

        pedidoDTO.setValor(pedidoService.calcularPreco(pedidoDTO));

        Assertions.assertEquals(0.00, pedidoDTO.getValor());
    }
}
