package com.Terranovans.NS.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class terrenoDTO {

    private Long idTerreno;

    private BigDecimal tamanoTerreno;

    private EnumType tipoTerreno;

    private String topografiaTerreno;

    private EnumType acceso;

    private String servicios;

    private String usoActual;

    private Boolean cercado;
}
