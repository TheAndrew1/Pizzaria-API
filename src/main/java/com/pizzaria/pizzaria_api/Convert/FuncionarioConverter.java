package com.pizzaria.pizzaria_api.Convert;

import com.pizzaria.pizzaria_api.DTO.FuncionarioDTO;
import com.pizzaria.pizzaria_api.Entity.Funcionario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioConverter {
    @Autowired
    private ModelMapper modelMapper;

    public FuncionarioDTO convertToFuncionarioDTO(Funcionario funcionario) {
        return modelMapper.map(funcionario, FuncionarioDTO.class);
    }

    public Funcionario convertToFuncionario(FuncionarioDTO funcionarioDTO) {
        return modelMapper.map(funcionarioDTO, Funcionario.class);
    }
}
