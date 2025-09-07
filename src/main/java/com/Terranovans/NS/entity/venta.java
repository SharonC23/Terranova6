package com.Terranovans.NS.entity;

import jakarta.persistence.*;
import lombok.Data;

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
    private estado estado;

    @Column(name = "nota", length = 200, nullable = true)
    private String nota;

    @Column(name = "metodoPago", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private metodoPago metodoPago;

    @Column(name = "gananciaNeta", nullable = false)
    private BigInteger gananciaNeta;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    // Relación con la entidad Producto
    private producto idProducto;

    @ManyToOne
    @JoinColumn(name = "cedula")
    // Relación con la entidad Usuario
    private usuario cedula;

}

