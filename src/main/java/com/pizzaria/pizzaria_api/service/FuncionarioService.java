package com.pizzaria.pizzaria_api.service;

import com.pizzaria.pizzaria_api.convert.FuncionarioConverter;
import com.pizzaria.pizzaria_api.dto.FuncionarioDTO;
import com.pizzaria.pizzaria_api.entity.Funcionario;
import com.pizzaria.pizzaria_api.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private FuncionarioConverter funcionarioConverter;
    @Autowired
    private PasswordEncoder psEncode;

    public FuncionarioDTO findById(final Long id) {
        return funcionarioConverter.convertToFuncionarioDTO(this.funcionarioRepository.findById(id).orElseThrow());
    }

    public List<FuncionarioDTO> findAll() {
        List<Funcionario> funcionarios = this.funcionarioRepository.findAll();

        return funcionarios.stream().map(item -> funcionarioConverter.convertToFuncionarioDTO(item)).toList();
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(FuncionarioDTO funcionarioDTO) {
        Assert.isTrue(!funcionarioDTO.getNome().isBlank(), "Nome inválido!");
        Assert.isTrue(!funcionarioDTO.getLogin().isBlank(), "Login inválido!");
        Assert.isTrue(!funcionarioDTO.getSenha().isBlank(), "Senha inválido!");

        funcionarioDTO.setSenha(psEncode.encode(funcionarioDTO.getSenha()));
        funcionarioDTO.setRole("ADMIN");

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

        funcionarioDTO.setSenha(psEncode.encode(funcionarioDTO.getSenha()));

        Funcionario funcionario = funcionarioConverter.convertToFuncionario(funcionarioDTO);
        this.funcionarioRepository.save(funcionario);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Funcionario funcionario = funcionarioConverter.convertToFuncionario(findById(id));
        this.funcionarioRepository.delete(funcionario);
    }
}
