package com.Terranovans.NS.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class imagenDTO {

    private Long idImagen;

    private Long idProducto;

    private String nombreArchivo;
}

