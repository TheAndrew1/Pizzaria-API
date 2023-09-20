package com.pizzaria.PizzariaAPI.Convert;

import com.pizzaria.PizzariaAPI.DTO.EnderecoDTO;
import com.pizzaria.PizzariaAPI.Entity.Endereco;
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
        EnderecoDTO enderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);
        return enderecoDTO;
    }

    public Endereco convertToEndereco(final EnderecoDTO enderecoDTO){
        Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
        return endereco;
    }
}
