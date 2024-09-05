package com.orderflow.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @Column(name = "codped")
    private Long codigoPedido;

    @Column(name = "datped")
    private Date dataPedido;

    @Column(name = "codcli")
    private Long codigoCliente;

    @Column(name = "codsta")
    private Long codigoStatus;

    @Column(name = "codpro")
    private Long codigoProduto;

    @Column(name = "qtdpro")
    private Long quantidadeProduto;

    @Column(name = "vlrtot")
    private BigDecimal valorTotal;

    public Long getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Long codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Long getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(Long codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public Long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Long getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Long quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
