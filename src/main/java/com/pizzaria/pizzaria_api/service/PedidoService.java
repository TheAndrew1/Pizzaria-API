package com.pizzaria.pizzaria_api.service;

import com.pizzaria.pizzaria_api.convert.PedidoConverter;
import com.pizzaria.pizzaria_api.dto.PedidoDTO;
import com.pizzaria.pizzaria_api.dto.ProdutoDTO;
import com.pizzaria.pizzaria_api.entity.Pedido;
import com.pizzaria.pizzaria_api.entity.Situacao;
import com.pizzaria.pizzaria_api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PedidoConverter pedidoConverter;

    public PedidoDTO findById(Long id) {
        return pedidoConverter.convertToPedidoDTO(this.pedidoRepository.findById(id).orElseThrow());
    }

    public List<PedidoDTO> findAll() {
        List<Pedido> pedidos = this.pedidoRepository.findAll();

        return pedidos.stream().map(item -> pedidoConverter.convertToPedidoDTO(item)).toList();
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(PedidoDTO pedidoDTO) {
        pedidoDTO.setData(LocalDate.now());
        pedidoDTO.setSituacao(Situacao.PREPARO);

        Assert.notNull(pedidoDTO.getPagamento(), "Forma de pagamento não pode ser nulo!");
        Assert.isTrue(pedidoDTO.getValor() >= 0, "Valor deve ser positivo!");

        pedidoDTO.setValor(calcularPreco(pedidoDTO));

        Pedido pedido = pedidoConverter.convertToPedido(pedidoDTO);
        this.pedidoRepository.save(pedido);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Long id, PedidoDTO pedidoDTO) {
        PedidoDTO pedidoDatabase = findById(id);
        Assert.notNull(pedidoDatabase, "Pedido não encontrado!");
        Assert.isTrue(pedidoDatabase.getId().equals(pedidoDTO.getId()), "Pedidos não conferem!");

        Assert.notNull(pedidoDTO.getData(), "Data não pode ser nula!");
        Assert.notNull(pedidoDTO.getSituacao(), "Situação não pode ser nula!");
        Assert.notNull(pedidoDTO.getPagamento(), "Forma de pagamento não pode ser nulo!");
        Assert.isTrue(pedidoDTO.getValor() >= 0, "Valor deve ser positivo!");

        pedidoDTO.setValor(calcularPreco(pedidoDTO));

        Pedido pedido = pedidoConverter.convertToPedido(pedidoDTO);
        this.pedidoRepository.save(pedido);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Pedido pedido = pedidoConverter.convertToPedido(findById(id));
        this.pedidoRepository.delete(pedido);
    }


    public double calcularPreco(PedidoDTO pedidoDTO) {
        if (pedidoDTO.getProdutos() != null)
        {
            double preco = 0;
            for(ProdutoDTO produtoDTO : pedidoDTO.getProdutos()){
                preco += produtoDTO.getValor();
            }
            return preco;
        }

        return 0.00;
    }
}
