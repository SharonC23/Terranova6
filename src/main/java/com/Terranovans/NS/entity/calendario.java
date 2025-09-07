package com.Terranovans.NS.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "calendario")
@Data
public class calendario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calendario")
    private Long idCalendario;

    @ManyToOne
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")  // FK correcta
    private usuario usuario;  // Relación con usuario
}

