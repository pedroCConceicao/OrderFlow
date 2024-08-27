package com.orderflow.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table("ETQADM.TPEDIDO")
public class Pedido implements Serializable {

    @Id
    private Long codigoPedido;

}
