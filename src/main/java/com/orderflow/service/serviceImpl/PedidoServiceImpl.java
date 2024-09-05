package com.orderflow.service.serviceImpl;

import com.orderflow.domain.Pedido;
import com.orderflow.repository.PedidoRepository;
import com.orderflow.service.PedidoService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> buscarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido internalizarPedido(Pedido pedido) throws Exception {
        if (pedido == null) {
            throw new Exception("Não tem pedido");
        }

        return pedidoRepository.save(pedido);
    }

}
