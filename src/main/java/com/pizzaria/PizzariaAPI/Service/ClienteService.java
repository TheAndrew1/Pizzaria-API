package com.pizzaria.PizzariaAPI.Service;

import com.pizzaria.PizzariaAPI.DTO.ClienteDTO;
import com.pizzaria.PizzariaAPI.Entity.Cliente;
import com.pizzaria.PizzariaAPI.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO findById(final Long id){
        return this.clienteRepository.findById(id).orElseThrow();
    }

    public List<ClienteDTO> findAll(){
        return this.clienteRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(final ClienteDTO ){

    }

    public ClienteDTO toClienteDTO(final Cliente cliente){

    }
}
