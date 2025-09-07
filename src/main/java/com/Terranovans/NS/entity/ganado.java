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

    @Column(name = "razaGanado", length = 50)
    private String razaGanado;

    @Column(name = "pesoGanado", nullable = false)
    private BigDecimal pesoGanado;

    @Column(name = "edadGanado", nullable = false)
    private Integer edadGanado;

    @Column(name = "Genero", length = 6)
    @Enumerated(EnumType.STRING)
    private GeneroGanado gereno;

    @Column(name = "tipoGanado", length = 50, nullable = false)
    private String tipoGanado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    private producto idProducto;

    @Column(name = "preniez", length = 7)
    private Boolean preniez;

    @Column(name = "estadoSanitario", length = 50, nullable = false)
    private String estadoSaniario;

    @Column(name = "cantidad")
    private Integer cantidad;



}
