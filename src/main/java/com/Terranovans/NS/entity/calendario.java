package com.Terranovans.NS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
    private Usuario usuario;  // Relación con usuario

    @OneToMany(mappedBy = "calendario", cascade = CascadeType.ALL)
    private List<disponibilidad> disponibilidades = new ArrayList<>();
}

