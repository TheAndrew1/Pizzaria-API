package com.pizzaria.PizzariaAPI.Service;

import com.pizzaria.PizzariaAPI.Convert.SaborConverter;
import com.pizzaria.PizzariaAPI.DTO.SaborDTO;
import com.pizzaria.PizzariaAPI.Entity.Sabor;
import com.pizzaria.PizzariaAPI.Repository.SaborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaborService {
    @Autowired
    private SaborRepository saborRepository;
    @Autowired
    private SaborConverter saborConverter;

    public SaborDTO findById(Long id) {
        return saborConverter.toSaborDTO(this.saborRepository.findById(id).orElseThrow());
    }

    public List<SaborDTO> findAll() {
        List<Sabor> sabores = this.saborRepository.findAll();
        List<SaborDTO> saboresDTO = new ArrayList<>();

        for (Sabor sabor : sabores) {
            saboresDTO.add(saborConverter.toSaborDTO(sabor));
        }

        return saboresDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(SaborDTO saborDTO) {
        Assert.isTrue(!saborDTO.getNome().isBlank(), "Deve conter nome do sabor!");
        Assert.isTrue(!saborDTO.getDescricao().isBlank(), "Deve conter descrição do sabor!");
        Assert.isTrue(saborDTO.getValor() > 0, "Valor deve ser positivo!");

        Sabor sabor = saborConverter.toSabor(saborDTO);
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

        Sabor sabor = saborConverter.toSabor(saborDTO);
        this.saborRepository.save(sabor);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Sabor sabor = saborConverter.toSabor(findById(id));
        this.saborRepository.delete(sabor);
    }
}
