package com.pizzaria.pizzaria_api.convert;

import com.pizzaria.pizzaria_api.dto.EnderecoDTO;
import com.pizzaria.pizzaria_api.entity.Endereco;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ClienteConverter clienteConverter;

    public EnderecoDTO convertToEnderecoDTO(final Endereco endereco){
        return modelMapper.map(endereco, EnderecoDTO.class);
    }

    public Endereco convertToEndereco(final EnderecoDTO enderecoDTO){
        return modelMapper.map(enderecoDTO, Endereco.class);
    }
}
