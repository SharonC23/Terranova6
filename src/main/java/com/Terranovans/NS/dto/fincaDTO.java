package com.Terranovans.NS.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class fincaDTO {

    private Long idFinca;

    private String espacioTotal;

    private String espacioConstruido;

    private String espacioDisponible;

    private Integer estadistica;

    private Integer numeroHabitaciones;

    private String numeroBanos;
}
