package com.Terranovans.NS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Citas")
@Data
public class cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCita")
    private Long idCita;

    @Column(name = "fechaCita", nullable = false)
    private LocalDateTime fechaCita;

    @Column(name = "estadoCita", length = 30, nullable = false)
    private String estadoCita;

    @Column(name = "ubicacionCita", length = 500, nullable = false)
    private String ubicacionCita;

    @Column(name = "horaCita", nullable = false)
    private LocalDateTime horaCita;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    // Relación con la entidad Producto
    private producto idProducto;

    @ManyToOne
    @JoinColumn(name = "cedula", unique = true)
    // Relación con la entidad Usuario
    private usuario cedula;
}
