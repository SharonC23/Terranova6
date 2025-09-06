package com.Terranovans.NS.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="favoritos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class favoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_favorito;

    @ManyToOne
    @JoinColumn (name = "cedula_usuario", insertable = false, updatable = false)
    private usuario usuario;

    @ManyToOne
    @JoinColumn (name = "id_producto", insertable = false, updatable = false)
    private producto producto;

}
