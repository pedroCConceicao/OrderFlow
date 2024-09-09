package com.orderflow.controller;

import com.orderflow.domain.Pedido;
import com.orderflow.exception.InternalServerErrorException;
import com.orderflow.service.PedidoService;
import com.orderflow.service.serviceImpl.PedidoServiceImpl;
import com.orderflow.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/pedidos")
public class PedidoController {

    private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/buscarPedidos")
    public ResponseEntity<?> buscarPedidos(@RequestParam(required = false) Long codigoPedido, @RequestParam(required = false) Date dataPedido, @RequestParam(required = false) Long codigoStatus, @RequestParam(required = false) Long codigoProduto, @RequestParam(required = false) Long codigoCliente) {
        try {
            logger.info("Buscando pedidos");
            return ResponseEntity.ok(pedidoService.buscarPedidos(codigoPedido, dataPedido, codigoStatus, codigoProduto, codigoCliente));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/internalizarPedido")
    public ResponseEntity<?> internalizarPedido(@RequestBody Pedido pedido) throws BadRequestException {
        logger.info("Internalizando pedido");
        try {
            return ResponseEntity.ok(pedidoService.internalizarPedido(pedido));
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (InternalServerErrorException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @PutMapping("/cancelarPedido")
    public ResponseEntity<?> cancelarPedido(@RequestParam Long numeroPedido) throws BadRequestException {
        logger.info("Cancelando pedido: " + numeroPedido);
        return ResponseEntity.ok(pedidoService.cancelarPedido(numeroPedido));
    }

}
