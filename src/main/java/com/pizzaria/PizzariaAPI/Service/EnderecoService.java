package com.pizzaria.PizzariaAPI.Service;

import com.pizzaria.PizzariaAPI.DTO.EnderecoDTO;
import com.pizzaria.PizzariaAPI.Entity.Endereco;
import com.pizzaria.PizzariaAPI.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoDTO toEnderecoDTO(final Endereco endereco){
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco.getId(), endereco.getBairro(), endereco.getRua(), endereco.getNumero());
        return enderecoDTO;
    }

    public Endereco toEndereco(final EnderecoDTO enderecoDTO){
        Endereco endereco = new Endereco(enderecoDTO.getId(), enderecoDTO.getBairro(), enderecoDTO.getRua(), enderecoDTO.getNumero());
        return endereco;
    }
}
