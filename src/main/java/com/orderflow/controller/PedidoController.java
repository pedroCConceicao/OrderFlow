package com.orderflow.controller;

import com.orderflow.domain.Pedido;
import com.orderflow.service.PedidoService;
import com.orderflow.service.serviceImpl.PedidoServiceImpl;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/pedidos")
public class PedidoController {

    private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/buscarPedidos")
    public ResponseEntity<?> buscarPedidos() {
        logger.info("Buscando pedidos");
        return ResponseEntity.ok(pedidoService.buscarPedidos());
    }

    @PostMapping("/internalizarPedido")
    public ResponseEntity<?> internalizarPedido(@RequestBody Pedido pedido) throws BadRequestException {
        logger.info("Internalizando pedido");
        try {
            return ResponseEntity.ok(pedidoService.internalizarPedido(pedido));
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

}
