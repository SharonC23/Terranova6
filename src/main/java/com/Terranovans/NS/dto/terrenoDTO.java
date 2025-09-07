package com.Terranovans.NS.dto;

import com.Terranovans.NS.entity.acceso;
import com.Terranovans.NS.entity.tipoTerreno;
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

    private Long idproducto;

    private BigDecimal tamanoTerreno;

    private tipoTerreno tipoTerreno;

    private String topografiaTerreno;

    private acceso acceso;

    private String servicios;

    private String usoActual;

    private Boolean cercado;
}
