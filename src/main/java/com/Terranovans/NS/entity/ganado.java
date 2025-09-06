package com.Terranovans.NS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name ="Ganados")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ganado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGanado")
    private Long idGanado;

    @Column(name = "razaGanado", length = 50, nullable = false)
    private String nombreGanado;

    @Column(name = "pesoGanado", nullable = false)
    private BigDecimal pesoGanado;

    @Column(name = "edadGanado", nullable = false)
    private Integer edadGanado;

    @Column(name = "Genero", length = 6, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumType Gereno;

    @Column(name = "tipoGanado", length = 50, nullable = false)
    private String tipoGanado;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    // Relación con la entidad Producto
    private producto idProducto;

    @Column(name = "preñez", length = 7, nullable = false)
    private Boolean preñez;

    @Column(name = "estadoSanitario", length = 50, nullable = false)
    private String estadoSaniario;

    @Column(name = "cantidad")
    private Integer cantidad;



}
