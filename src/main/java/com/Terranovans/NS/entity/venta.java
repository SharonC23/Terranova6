package com.Terranovans.NS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
@Data
public class venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private Long idVenta;

    @Column(name = "fechaVenta", nullable = false)
    private LocalDateTime fechaVenta;

    @Column(name = "estado", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumType estado;

    @Column(name = "nota", length = 200, nullable = true)
    private String nota;

    @Column(name = "metodoPago", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumType metodoPago;

    @Column(name = "gananciaNeta", nullable = false)
    private BigInteger gananciaNeta;

}

