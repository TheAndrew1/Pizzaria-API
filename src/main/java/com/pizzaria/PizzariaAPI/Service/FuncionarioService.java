package com.pizzaria.PizzariaAPI.Service;

import com.pizzaria.PizzariaAPI.DTO.FuncionarioDTO;
import com.pizzaria.PizzariaAPI.Entity.Funcionario;
import com.pizzaria.PizzariaAPI.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioDTO findById(final Long id) {
        return toFuncionarioDTO(this.funcionarioRepository.findById(id).orElseThrow());
    }

    public List<FuncionarioDTO> findAll() {
        List<Funcionario> funcionarios = this.funcionarioRepository.findAll();
        List<FuncionarioDTO> funcionariosDTO = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            funcionariosDTO.add(toFuncionarioDTO(funcionario));
        }

        return funcionariosDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(FuncionarioDTO funcionarioDTO) {
        Assert.isTrue(!funcionarioDTO.getNome().isBlank(), "Nome inválido!");
        Assert.isTrue(!funcionarioDTO.getLogin().isBlank(), "Login inválido!");
        Assert.isTrue(!funcionarioDTO.getSenha().isBlank(), "Senha inválido!");

        Funcionario funcionario = toFuncionario(funcionarioDTO);
        this.funcionarioRepository.save(funcionario);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Long id, FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO funcionarioNoBanco = findById(id);
        Assert.notNull(funcionarioNoBanco, "Funcionário não encontrado!");
        Assert.isTrue(funcionarioNoBanco.getId().equals(funcionarioDTO.getId()), "Funcionários não conferem!");

        Assert.isTrue(!funcionarioDTO.getNome().isBlank(), "Nome inválido!");
        Assert.isTrue(!funcionarioDTO.getLogin().isBlank(), "Login inválido!");
        Assert.isTrue(!funcionarioDTO.getSenha().isBlank(), "Senha inválido!");

        Funcionario funcionario = toFuncionario(funcionarioDTO);
        this.funcionarioRepository.save(funcionario);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Funcionario funcionario = toFuncionario(findById(id));
        this.funcionarioRepository.delete(funcionario);
    }

    public FuncionarioDTO toFuncionarioDTO(Funcionario funcionario) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario.getId(), funcionario.getNome(), funcionario.getLogin(), funcionario.getSenha());
        return funcionarioDTO;
    }

    public Funcionario toFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario(funcionarioDTO.getId(), funcionarioDTO.getNome(), funcionarioDTO.getLogin(), funcionarioDTO.getSenha());
        return funcionario;
    }
}
