package com.Terranovans.NS.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Productos")
@Data
public class producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long idProducto;

    @Column(name = "nombreProducto", length = 45, nullable = false, unique = true)
    private String nombreProducto;

    @Column(name = "tipoProducto", length = 30, nullable = false)
    private String tipoProducto;

    @Column(name = "precioProducto", nullable = false)
    private BigDecimal precioProducto;

    @Column(name = "descripcion", length = 500, nullable = false)
    private String descripcion;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @Column(name = "fechaPublicacion", nullable = false)
    private LocalDateTime fechaPublicacion;

    @Column(name = "ubicacionProducto", length = 200, nullable = false)
    private String ubicacionProducto;

    private Long usuario;

    @ManyToOne
    @JoinColumn(name = "cedula", unique = true)
    // Relación con la entidad Producto
    private Usuario cedula;



}
