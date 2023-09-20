package com.pizzaria.pizzaria_api.convert;

import com.pizzaria.pizzaria_api.dto.FuncionarioDTO;
import com.pizzaria.pizzaria_api.entity.Funcionario;
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
