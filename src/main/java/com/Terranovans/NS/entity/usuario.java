package com.Terranovans.NS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name ="Usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class usuario {


    @Id
    @Column(name = "cedula", length = 20, unique = true)
    private String cedula;

    @Column(name = "nombres", length = 45, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 45, nullable = false)
    private String apellidos;

    @Column(name = "email", length = 45, unique = true, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "nacimiento", nullable = false)
    private LocalDateTime nacimiento;

}
