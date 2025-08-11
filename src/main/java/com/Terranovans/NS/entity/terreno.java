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

    @Column(name = "tipoTerreno", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumType tipoTerreno;

    @Column(name = "topografiaTerreno", length = 45, nullable = false)
    private String topografiaTerreno;

    @Column(name = "acceso", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumType acceso;

    @Column(name = "servicios", length = 500, nullable = false)
    private String servicios;

    @Column(name = "usoActual", length = 45, nullable = false)
    private String usoActual;

    @Column(name = "cercado", length = 2, nullable = false)
    private Boolean cercado;
}

