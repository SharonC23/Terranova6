package com.Terranovans.NS.dto;


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
    private Integer estrato;
    private Integer numeroHabitaciones;
    private String numeroBanos;
    private Long idProducto; // 👈 Relación con producto
}

