package com.pizzaria.PizzariaAPI.Service;

import com.pizzaria.PizzariaAPI.DTO.ClienteDTO;
import com.pizzaria.PizzariaAPI.Entity.Cliente;
import com.pizzaria.PizzariaAPI.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO findById(final Long id){
        return toClienteDTO(this.clienteRepository.findById(id).orElseThrow());
    }

    public List<ClienteDTO> findAll(){
        List<Cliente> clientes =  this.clienteRepository.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();

        for (Cliente cliente : clientes){
            clientesDTO.add(toClienteDTO(cliente));
        }

        return clientesDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(final ClienteDTO clienteDTO){

    }

    public ClienteDTO toClienteDTO(final Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getIdade(), cliente.getEmail(), cliente.getSenha());
        return clienteDTO;
    }

    public Cliente toCliente(final ClienteDTO clienteDTO){
        Cliente cliente = new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getIdade(), clienteDTO.getEmail(), clienteDTO.getSenha());
        return cliente;
    }
}
