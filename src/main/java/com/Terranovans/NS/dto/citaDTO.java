package com.Terranovans.NS.dto;


import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class citaDTO {
    private Long idCita;
    private LocalDateTime fechaCita;
    private String estadoCita;
    private String ubicacionCita;
    private LocalDateTime horaCita;
    private Long idDisponibilidad;
    private Long idProducto;
    private String cedula;
}

