package com.Terranovans.NS.dto;



import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class disponibilidadDTO {
    private Long idDisponibilidad;
    private LocalDateTime fecha;
    private LocalTime hora;
    private Boolean disponible;
    private Long idCalendario;
}

