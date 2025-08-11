package com.Terranovans.NS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Notificaciones")
@Data
public class notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNotification")
    private Long idNotification;

    @Column(name = "mensajeNotificacion", length = 300, nullable = false)
    private String mensajeNotificacion;

    @Column(name = "fechaNotification", nullable = false)
    private LocalDateTime fechaNotification; // Fecha y hora de la notificación

    @Column(name = "tipo", length = 50)
    private String tipo;

    @Column(name = "leida")
    private Boolean leida;

}
