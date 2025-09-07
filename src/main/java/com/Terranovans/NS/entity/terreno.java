package com.Terranovans.NS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "Terrenos")
@Data
public class terreno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTerreno")
    private Long idTerreno;

    @Column(name = "tamanoTerreno", nullable = false)
    private BigDecimal tamanoTerreno;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoTerreno", nullable = false)
    private tipoTerreno tipoTerreno;

    @Column(name = "topografiaTerreno", length = 45, nullable = false)
    private String topografiaTerreno;

    @Enumerated(EnumType.STRING)
    @Column(name = "acceso", nullable = false)
    private acceso acceso;

    @Column(name = "servicios", length = 500, nullable = false)
    private String servicios;

    @Column(name = "usoActual", length = 45, nullable = false)
    private String usoActual;

    @Column(name = "cercado", nullable = false)
    private Boolean cercado;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    // Relación con la entidad Producto
    private producto idProducto;
}

