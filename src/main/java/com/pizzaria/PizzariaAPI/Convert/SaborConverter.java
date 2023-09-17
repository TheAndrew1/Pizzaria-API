package com.pizzaria.PizzariaAPI.Convert;

import com.pizzaria.PizzariaAPI.DTO.SaborDTO;
import com.pizzaria.PizzariaAPI.Entity.Sabor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaborConverter {
    @Autowired
    private ModelMapper modelMapper;

    public SaborDTO convertToSaborDTO(Sabor sabor) {
        SaborDTO saborDTO = modelMapper.map(sabor, SaborDTO.class);
        return saborDTO;
    }

    public Sabor convertToSabor(SaborDTO saborDTO) {
        Sabor sabor = modelMapper.map(saborDTO, Sabor.class);
        return sabor;
    }
}
