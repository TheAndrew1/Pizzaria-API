package com.pizzaria.pizzaria_api.Convert;

import com.pizzaria.pizzaria_api.DTO.SaborDTO;
import com.pizzaria.pizzaria_api.Entity.Sabor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaborConverter {
    @Autowired
    private ModelMapper modelMapper;

    public SaborDTO convertToSaborDTO(Sabor sabor) {
        return modelMapper.map(sabor, SaborDTO.class);
    }

    public Sabor convertToSabor(SaborDTO saborDTO) {
        return modelMapper.map(saborDTO, Sabor.class);
    }
}
