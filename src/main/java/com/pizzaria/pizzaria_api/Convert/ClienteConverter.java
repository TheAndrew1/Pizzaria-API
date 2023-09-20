package com.pizzaria.pizzaria_api.Convert;

import com.pizzaria.pizzaria_api.DTO.ClienteDTO;
import com.pizzaria.pizzaria_api.Entity.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {
    @Autowired
    private ModelMapper modelMapper;
    public ClienteDTO convertToClienteDTO(final Cliente cliente){
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    public Cliente convertToCliente(final ClienteDTO clienteDTO){
        return modelMapper.map(clienteDTO, Cliente.class);
    }
}