package com.orderflow.service.serviceImpl;

import com.orderflow.domain.Pedido;
import com.orderflow.repository.PedidoRepository;
import com.orderflow.service.PedidoService;
import jakarta.transaction.Transactional;
import com.orderflow.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private static final Logger logger = LoggerFactory.getLogger(PedidoServiceImpl.class);

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> buscarPedidos(Long codigoPedido, Date dataPedido, Long codigoStatus, Long codigoProduto, Long codigoCliente) {
        Pedido pedido = new Pedido();
        pedido.setCodigoPedido(codigoPedido);
        pedido.setDataPedido(dataPedido);
        pedido.setCodigoStatus(codigoStatus);
        pedido.setCodigoProduto(codigoProduto);
        pedido.setCodigoCliente(codigoCliente);

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues();

        Example<Pedido> example = Example.of(pedido, matcher);

        return pedidoRepository.findAll(example);
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

    @Override
    public String cancelarPedido(Long numeroPedido) throws BadRequestException {
        Pedido pedido = pedidoRepository.findByCodigoPedido(numeroPedido);

        // PEDIDO REALIZADO (1) / PEDIDO CONFIRMADO (2) / ENTREGUE (3) / CANCELADO (4)
        pedido.setCodigoStatus(4L);

        pedidoRepository.save(pedido);

        return "Pedido Cancelado";
    }

}
