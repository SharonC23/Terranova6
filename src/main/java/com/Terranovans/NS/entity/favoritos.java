package com.Terranovans.NS.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favoritos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class favoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_favorito;

    @ManyToOne
    @JoinColumn(name = "cedula", referencedColumnName = "cedula", nullable = false)
    private usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
    private producto producto;
}

