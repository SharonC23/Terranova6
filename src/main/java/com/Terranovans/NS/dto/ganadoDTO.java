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
public class ganadoDTO {

    private Long idGanado;

    private String nombreGanado;

    private BigDecimal pesoGanado;

    private Integer edadGanado;

    private EnumType sexo;

    private String tipoGanado;

    private Boolean GestacionGanado;

    private String estadoSaniario;

    private Integer cantidad;
}
