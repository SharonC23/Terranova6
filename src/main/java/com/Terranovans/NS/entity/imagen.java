package com.Terranovans.NS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Imagenes")
@Data
public class imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idImagen")
    private Long idImagen;

    @Column(name = "nombreArchivo", length = 255, unique = true)
    private String nombreArchivo;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private producto idProducto;

}
