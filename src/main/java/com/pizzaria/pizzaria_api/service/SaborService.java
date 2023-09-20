package com.pizzaria.pizzaria_api.service;

import com.pizzaria.pizzaria_api.convert.SaborConverter;
import com.pizzaria.pizzaria_api.dto.SaborDTO;
import com.pizzaria.pizzaria_api.entity.Sabor;
import com.pizzaria.pizzaria_api.repository.SaborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class SaborService {
    @Autowired
    private SaborRepository saborRepository;
    @Autowired
    private SaborConverter saborConverter;

    public SaborDTO findById(Long id) {
        return saborConverter.convertToSaborDTO(this.saborRepository.findById(id).orElseThrow());
    }

    public List<SaborDTO> findAll() {
        List<Sabor> sabores = this.saborRepository.findAll();

        return sabores.stream().map(item -> saborConverter.convertToSaborDTO(item)).toList();
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(SaborDTO saborDTO) {
        Assert.isTrue(!saborDTO.getNome().isBlank(), "Deve conter nome do sabor!");
        Assert.isTrue(!saborDTO.getDescricao().isBlank(), "Deve conter descrição do sabor!");
        Assert.isTrue(saborDTO.getValor() > 0, "Valor deve ser positivo!");

        Sabor sabor = saborConverter.convertToSabor(saborDTO);
        this.saborRepository.save(sabor);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Long id, SaborDTO saborDTO) {
        SaborDTO saborDatabase = findById(id);
        Assert.notNull(saborDatabase, "Sabor não encontrado!");
        Assert.isTrue(saborDatabase.getId().equals(saborDTO.getId()), "Sabores não conferem!");

        Assert.isTrue(!saborDTO.getNome().isBlank(), "Deve conter nome do sabor!");
        Assert.isTrue(!saborDTO.getDescricao().isBlank(), "Deve conter descrição do sabor!");
        Assert.isTrue(saborDTO.getValor() > 0, "Valor deve ser positivo!");

        Sabor sabor = saborConverter.convertToSabor(saborDTO);
        this.saborRepository.save(sabor);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Sabor sabor = saborConverter.convertToSabor(findById(id));
        this.saborRepository.delete(sabor);
    }
}
