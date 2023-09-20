package com.pizzaria.pizzaria_api.convert;

import com.pizzaria.pizzaria_api.dto.SaborDTO;
import com.pizzaria.pizzaria_api.entity.Sabor;
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
