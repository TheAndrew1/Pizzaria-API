package com.pizzaria.PizzariaAPI.Service;

import com.pizzaria.PizzariaAPI.Convert.PedidoConverter;
import com.pizzaria.PizzariaAPI.DTO.PedidoDTO;
import com.pizzaria.PizzariaAPI.DTO.ProdutoDTO;
import com.pizzaria.PizzariaAPI.Entity.Pedido;
import com.pizzaria.PizzariaAPI.Repository.PedidoRepository;
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

        Assert.notNull(pedidoDTO.getData(), "Data não pode ser nula!");
        Assert.notNull(pedidoDTO.getSituacao(), "Situação não pode ser nula!");
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

        pedidoDTO.setData(pedidoDatabase.getData());
        Assert.notNull(pedidoDTO.getData(), "Data não pode ser nula!");
        Assert.notNull(pedidoDTO.getSituacao(), "Situação não pode ser nula!");
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
