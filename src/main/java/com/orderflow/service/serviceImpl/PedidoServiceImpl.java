package com.orderflow.service.serviceImpl;

import com.orderflow.domain.Pedido;
import com.orderflow.repository.PedidoRepository;
import com.orderflow.service.PedidoService;
import jakarta.transaction.Transactional;
import com.orderflow.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private static final Logger logger = LoggerFactory.getLogger(PedidoServiceImpl.class);

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> buscarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    @Transactional
    public Pedido internalizarPedido(Pedido pedido) throws BadRequestException {
        if (pedido == null) {
            logger.error("Tentativa de internalização de pedido falhou: Pedido nulo.");
            throw new BadRequestException("Não há pedido no corpo da requisição.");
        }

        if (pedido.getCodigoCliente() == null || pedido.getCodigoProduto() == null) {
            logger.error("Pedido inválido: código do cliente ou produto ausente.");
            throw new BadRequestException("Código do cliente ou produto está ausente.");
        }

        if (pedido.getQuantidadeProduto() == null || pedido.getQuantidadeProduto() <= 0) {
            logger.error("Pedido inválido: quantidade de produto deve ser maior que zero.");
            throw new BadRequestException("Quantidade de produto inválida.");
        }

        if (pedido.getValorTotal() == null || pedido.getValorTotal().equals(BigDecimal.ZERO)) {
            logger.error("Tentativa de internalização de pedido falhou: Valor total zerado.");
            throw new BadRequestException("Valor do pedido zerado, impossível internalizá-lo.");
        }

        logger.info("Internalizando pedido de código: {}", pedido.getCodigoPedido());

        pedido.setCodigoStatus(1L);

        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        logger.info("Pedido internalizado com sucesso: código {}", pedidoSalvo.getCodigoPedido());

        return pedidoSalvo;
    }

}
