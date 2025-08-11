package com.Terranovans.NS.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class notificacionDTO {

    private Long idNotification;

    private String mensajeNotificacion;

    private LocalDateTime fechaNotification;

    private String tipo;

    private Boolean leida;
}
