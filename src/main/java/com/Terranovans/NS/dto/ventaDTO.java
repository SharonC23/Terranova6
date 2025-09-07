package com.Terranovans.NS.dto;

import com.Terranovans.NS.entity.estado;
import com.Terranovans.NS.entity.metodoPago;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ventaDTO {


    private Long idVenta;

    private String cedula;

    private Long idProducto;

    private LocalDateTime fechaVenta;

    private estado estado;

    private String nota;

    private metodoPago metodoPago;

    private BigInteger gananciaNeta;
}
