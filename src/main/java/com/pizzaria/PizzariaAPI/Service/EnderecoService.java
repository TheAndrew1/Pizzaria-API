package com.pizzaria.PizzariaAPI.Service;

import com.pizzaria.PizzariaAPI.DTO.EnderecoDTO;
import com.pizzaria.PizzariaAPI.Entity.Endereco;
import com.pizzaria.PizzariaAPI.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoDTO findById(final Long id){
        return toEnderecoDTO(this.enderecoRepository.findById(id).orElseThrow());
    }

    public List<EnderecoDTO> findAll(){
        List<Endereco> enderecos =  this.enderecoRepository.findAll();
        List<EnderecoDTO> enderecosDTO = new ArrayList<>();

        for (Endereco endereco : enderecos){
            enderecosDTO.add(toEnderecoDTO(endereco));
        }

        return enderecosDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(final EnderecoDTO enderecoDTO){
        Assert.isTrue(!enderecoDTO.getBairro().isBlank(), "Bairro inválido!");

        Assert.isTrue(!enderecoDTO.getRua().isBlank(), "Rua inválida!");

        Assert.notNull(enderecoDTO.getNumero(), "Número da residência não pode nula!");
        Assert.isTrue(enderecoDTO.getNumero() > 0, "Número da residência não pode ser negativa!");

        Endereco endereco = toEndereco(enderecoDTO);
        this.enderecoRepository.save(endereco);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(final Long id, final EnderecoDTO enderecoDTO){
        EnderecoDTO enderecoDatabaase = findById(id);
        Assert.notNull(enderecoDatabaase, "Endereço não encontrado!");
        Assert.isTrue(enderecoDatabaase.getId().equals(enderecoDTO.getId()), "Endereços não conferem!");

        Assert.isTrue(!enderecoDTO.getBairro().isBlank(), "Bairro inválido!");

        Assert.isTrue(!enderecoDTO.getRua().isBlank(), "Rua inválida!");

        Assert.notNull(enderecoDTO.getNumero(), "Número da residência não pode nula!");
        Assert.isTrue(enderecoDTO.getNumero() > 0, "Número da residência não pode ser negativa!");

        Endereco endereco = toEndereco(enderecoDTO);
        this.enderecoRepository.save(endereco);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(final Long id){
        Endereco endereco = toEndereco(findById(id));
        this.enderecoRepository.delete(endereco);
    }

    public EnderecoDTO toEnderecoDTO(final Endereco endereco){
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco.getId(), endereco.getBairro(), endereco.getRua(), endereco.getNumero());
        return enderecoDTO;
    }

    public Endereco toEndereco(final EnderecoDTO enderecoDTO){
        Endereco endereco = new Endereco(enderecoDTO.getId(), enderecoDTO.getBairro(), enderecoDTO.getRua(), enderecoDTO.getNumero());
        return endereco;
    }
}
