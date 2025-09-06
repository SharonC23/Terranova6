package com.Terranovans.NS.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Fincas")
@Data
public class finca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFinca")
    private Long idFinca;

    @Column(name = "espacioTotal", length = 30, nullable = false)
    private String espacioTotal;

    @Column(name = "espacioConstruido", length = 30, nullable = false)
    private String espacioConstruido;

    @Column(name = "espacioDisponible", length = 30, nullable = false)
    private String espacioDisponible;

    @Column(name = "estrato", nullable = false)
    private Integer estrato;

    @Column(name = "numeroHabitaciones", nullable = false)
    private Integer numeroHabitaciones;

    @Column(name = "numeroBanos", length = 20)
    private String numeroBanos;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    // Relación con la entidad Producto
    private producto idProducto;

}