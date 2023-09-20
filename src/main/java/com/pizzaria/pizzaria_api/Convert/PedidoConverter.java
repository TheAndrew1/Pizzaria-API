package com.pizzaria.pizzaria_api.Convert;

import com.pizzaria.pizzaria_api.DTO.PedidoDTO;
import com.pizzaria.pizzaria_api.Entity.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoConverter {
    @Autowired
    private ModelMapper modelMapper;

    public PedidoDTO convertToPedidoDTO(Pedido pedido) {
        return modelMapper.map(pedido, PedidoDTO.class);
    }

    public Pedido convertToPedido(PedidoDTO pedidoDTO) {
        return modelMapper.map(pedidoDTO, Pedido.class);
    }
}
