package com.pizzaria.PizzariaAPI.Convert;

import com.pizzaria.PizzariaAPI.DTO.FuncionarioDTO;
import com.pizzaria.PizzariaAPI.Entity.Funcionario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioConverter {
    @Autowired
    private ModelMapper modelMapper;

    public FuncionarioDTO convertToFuncionarioDTO(Funcionario funcionario) {
        FuncionarioDTO funcionarioDTO = modelMapper.map(funcionario, FuncionarioDTO.class);
        return funcionarioDTO;
    }

    public Funcionario convertToFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = modelMapper.map(funcionarioDTO, Funcionario.class);
        return funcionario;
    }
}
