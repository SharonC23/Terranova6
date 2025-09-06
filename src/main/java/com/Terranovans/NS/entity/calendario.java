package com.Terranovans.NS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Calendarios")
@Data
public class calendario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCalendario")
    private Long idCalendario;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private usuario idUsuario;
}
