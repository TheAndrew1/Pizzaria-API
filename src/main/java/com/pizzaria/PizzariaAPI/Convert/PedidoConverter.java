package com.pizzaria.PizzariaAPI.Convert;

import com.pizzaria.PizzariaAPI.DTO.ClienteDTO;
import com.pizzaria.PizzariaAPI.DTO.EnderecoDTO;
import com.pizzaria.PizzariaAPI.DTO.FuncionarioDTO;
import com.pizzaria.PizzariaAPI.DTO.PedidoDTO;
import com.pizzaria.PizzariaAPI.Entity.Cliente;
import com.pizzaria.PizzariaAPI.Entity.Endereco;
import com.pizzaria.PizzariaAPI.Entity.Funcionario;
import com.pizzaria.PizzariaAPI.Entity.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoConverter {
    @Autowired
    private ModelMapper modelMapper;

    public PedidoDTO convertToPedidoDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
        pedidoDTO.setClienteDTO(modelMapper.map(pedido.getCliente(), ClienteDTO.class));
        pedidoDTO.setEnderecoDTO(modelMapper.map(pedido.getEndereco(), EnderecoDTO.class));
//        pedidoDTO.setFuncionarioDTO(modelMapper.map(pedido.getFuncionario(), FuncionarioDTO.class));
        return pedidoDTO;
    }

    public Pedido convertToPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);
        pedido.setCliente(modelMapper.map(pedidoDTO.getClienteDTO(), Cliente.class));
        pedido.setEndereco(modelMapper.map(pedidoDTO.getEnderecoDTO(), Endereco.class));
//        pedido.setFuncionario(modelMapper.map(pedidoDTO.getFuncionarioDTO(), Funcionario.class));
        return pedido;
    }
}
