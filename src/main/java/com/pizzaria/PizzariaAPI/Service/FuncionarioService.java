package com.pizzaria.PizzariaAPI.Service;

import com.pizzaria.PizzariaAPI.Convert.FuncionarioConverter;
import com.pizzaria.PizzariaAPI.DTO.FuncionarioDTO;
import com.pizzaria.PizzariaAPI.Entity.Funcionario;
import com.pizzaria.PizzariaAPI.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private FuncionarioConverter funcionarioConverter;

    public FuncionarioDTO findById(final Long id) {
        return funcionarioConverter.convertToFuncionarioDTO(this.funcionarioRepository.findById(id).orElseThrow());
    }

    public List<FuncionarioDTO> findAll() {
        List<Funcionario> funcionarios = this.funcionarioRepository.findAll();

        return funcionarios.stream().map(item -> funcionarioConverter.convertToFuncionarioDTO(item)).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(FuncionarioDTO funcionarioDTO) {
        Assert.isTrue(!funcionarioDTO.getNome().isBlank(), "Nome inválido!");
        Assert.isTrue(!funcionarioDTO.getLogin().isBlank(), "Login inválido!");
        Assert.isTrue(!funcionarioDTO.getSenha().isBlank(), "Senha inválido!");

        Funcionario funcionario = funcionarioConverter.convertToFuncionario(funcionarioDTO);
        this.funcionarioRepository.save(funcionario);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Long id, FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO funcionarioDatabaase = findById(id);
        Assert.notNull(funcionarioDatabaase, "Funcionário não encontrado!");
        Assert.isTrue(funcionarioDatabaase.getId().equals(funcionarioDTO.getId()), "Funcionários não conferem!");

        Assert.isTrue(!funcionarioDTO.getNome().isBlank(), "Nome inválido!");
        Assert.isTrue(!funcionarioDTO.getLogin().isBlank(), "Login inválido!");
        Assert.isTrue(!funcionarioDTO.getSenha().isBlank(), "Senha inválido!");

        Funcionario funcionario = funcionarioConverter.convertToFuncionario(funcionarioDTO);
        this.funcionarioRepository.save(funcionario);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Funcionario funcionario = funcionarioConverter.convertToFuncionario(findById(id));
        this.funcionarioRepository.delete(funcionario);
    }
}
