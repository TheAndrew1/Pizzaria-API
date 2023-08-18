package com.pizzaria.PizzariaAPI.Convert;

import com.pizzaria.PizzariaAPI.DTO.PedidoDTO;
import com.pizzaria.PizzariaAPI.Entity.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ClienteConverter clienteConverter;
    @Autowired
    private EnderecoConverter enderecoConverter;
    @Autowired
    private FuncionarioConverter funcionarioConverter;

    public PedidoDTO convertToPedidoDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
//        pedidoDTO.setClienteDTO(clienteConverter.convertToClienteDTO(pedido.getCliente()));
//        pedidoDTO.setEnderecoDTO(enderecoConverter.convertToEnderecoDTO(pedido.getEndereco()));
//        pedidoDTO.setFuncionarioDTO(funcionarioConverter.convertToFuncionarioDTO(pedido.getFuncionario()));
        return pedidoDTO;
    }

    public Pedido convertToPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);
//        pedido.setCliente(clienteConverter.convertToCliente(pedidoDTO.getClienteDTO()));
//        pedido.setEndereco(enderecoConverter.convertToEndereco(pedidoDTO.getEnderecoDTO()));
//        pedido.setFuncionario(funcionarioConverter.convertToFuncionario(pedidoDTO.getFuncionarioDTO()));
        return pedido;
    }
}
