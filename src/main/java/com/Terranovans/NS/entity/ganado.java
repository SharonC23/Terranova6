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

    @Column(name = "sexoGanado", length = 6, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumType sexo;

    @Column(name = "tipoGanado", length = 50, nullable = false)
    private String tipoGanado;

    @Column(name = "gestacionGanado", length = 7, nullable = false)
    private Boolean GestacionGanado;

    @Column(name = "estadoSanitario", length = 50, nullable = false)
    private String estadoSaniario;

    @Column(name = "cantidad")
    private Integer cantidad;



}
