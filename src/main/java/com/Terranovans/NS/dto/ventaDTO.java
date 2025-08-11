package com.Terranovans.NS.dto;

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

    private LocalDateTime fechaVenta;

    private EnumType estado;

    private String nota;

    private EnumType metodoPago;

    private BigInteger gananciaNeta;
}
