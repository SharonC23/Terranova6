package com.Terranovans.NS.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class productoDTO {

    private Long idProducto;

    private Long cedula;

    private String nombreProducto;

    private String tipoProducto;

    private BigDecimal precioProducto;

    private String descripcion;

    private String estado;

    private LocalDateTime fechaPublicacion;

    private String ubicacionProducto;
}
