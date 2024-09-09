package com.orderflow.service;

import com.orderflow.domain.Pedido;
import com.orderflow.exception.BadRequestException;

import java.util.Date;
import java.util.List;

public interface PedidoService {

    List<Pedido> buscarPedidos(Long codigoPedido, Date dataPedido, Long codigoStatus, Long codigoProduto, Long codigoCliente);

    Pedido internalizarPedido(Pedido pedido) throws BadRequestException;

    String cancelarPedido(Long codigoPedido) throws BadRequestException;

    String confirmarPedido(Long codigoPedido) throws BadRequestException;
}
