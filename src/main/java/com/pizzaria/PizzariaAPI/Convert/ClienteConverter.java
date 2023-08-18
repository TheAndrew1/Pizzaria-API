package com.pizzaria.PizzariaAPI.Convert;

import com.pizzaria.PizzariaAPI.DTO.ClienteDTO;
import com.pizzaria.PizzariaAPI.Entity.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {
    @Autowired
    private ModelMapper modelMapper;
    public ClienteDTO convertToClienteDTO(final Cliente cliente){
        ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        return clienteDTO;
    }

    public Cliente convertToCliente(final ClienteDTO clienteDTO){
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        return cliente;
    }
}