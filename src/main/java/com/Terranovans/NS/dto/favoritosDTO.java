package com.Terranovans.NS.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class favoritosDTO {
    private Long id_favorito;
    private String cedula;
    private Long idProducto;
}

