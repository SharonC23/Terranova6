package com.Terranovans.NS.dto;

import com.Terranovans.NS.entity.GeneroGanado;
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

    private String razaGanado;

    private Long idproducto;

    private BigDecimal pesoGanado;

    private Integer edadGanado;

    private GeneroGanado genero;

    private String tipoGanado;

    private Boolean peniez;

    private String estadoSaniario;

    private Integer cantidad;
}
