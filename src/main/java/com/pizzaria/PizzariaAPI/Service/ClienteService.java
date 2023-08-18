package com.pizzaria.PizzariaAPI.Service;

import com.pizzaria.PizzariaAPI.Convert.ClienteConverter;
import com.pizzaria.PizzariaAPI.DTO.ClienteDTO;
import com.pizzaria.PizzariaAPI.Entity.Cliente;
import com.pizzaria.PizzariaAPI.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteConverter clienteConverter;

    public ClienteDTO findById(final Long id){
        return clienteConverter.convertToClienteDTO(this.clienteRepository.findById(id).orElseThrow());
    }

    public List<ClienteDTO> findAll(){
        List<Cliente> clientes =  this.clienteRepository.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();

        for (Cliente cliente : clientes){
            clientesDTO.add(clienteConverter.convertToClienteDTO(cliente));
        }

        return clientesDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(final ClienteDTO clienteDTO){
        Assert.isTrue(!clienteDTO.getNome().isBlank(), "Nome inválido!");

        Assert.notNull(clienteDTO.getIdade(), "Idade não pode ser nula!");
        Assert.isTrue(clienteDTO.getIdade() > 0, "Idade não pode ser negativa!");

        Assert.isTrue(!clienteDTO.getEmail().isBlank(), "Deve conter email!");
        Assert.isTrue(clienteDTO.getEmail().matches("[a-zA-Z0-9]+@[a-z]+[.]{1}[a-z]+"), "Formato do email inválido!");

        //Assert.isTrue(!clienteDTO.getSenha().isBlank(), "Deve conter senha!");

        Cliente cliente = clienteConverter.convertToCliente(clienteDTO);
        this.clienteRepository.save(cliente);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(final Long id, final ClienteDTO clienteDTO){
        ClienteDTO clienteDatabase = findById(id);
        Assert.notNull(clienteDatabase, "Cliente não encontrado!");
        Assert.isTrue(clienteDatabase.getId().equals(clienteDTO.getId()), "Clientes não conferem!");

        Assert.isTrue(!clienteDTO.getNome().isBlank(), "Nome inválido!");

        Assert.notNull(clienteDTO.getIdade(), "Idade não pode ser nula!");
        Assert.isTrue(clienteDTO.getIdade() > 0, "Idade não pode ser negativa!");

        Assert.isTrue(!clienteDTO.getEmail().isBlank(), "Deve conter email!");
        Assert.isTrue(clienteDTO.getEmail().matches("[a-zA-Z0-9]+@[a-z]+[.]{1}[a-z]+"), "Formato do email inválido!");

        //Assert.isTrue(!clienteDTO.getSenha().isBlank(), "Deve conter senha!");

        Cliente cliente = clienteConverter.convertToCliente(clienteDTO);
        this.clienteRepository.save(cliente);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(final Long id){
        Cliente cliente = clienteConverter.convertToCliente(findById(id));
        this.clienteRepository.delete(cliente);
    }
}
