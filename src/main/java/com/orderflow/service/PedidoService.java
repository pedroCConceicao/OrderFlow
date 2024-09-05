package com.orderflow.service;

import com.orderflow.domain.Pedido;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface PedidoService {

    List<Pedido> buscarPedidos();

    Pedido internalizarPedido(Pedido pedido) throws Exception;

}
