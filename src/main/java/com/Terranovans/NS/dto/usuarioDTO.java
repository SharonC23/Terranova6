package com.Terranovans.NS.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class usuarioDTO {

    private String cedula;

    private String nombres;

    private String apellidos;

    private String email;

    private String password;

    private LocalDateTime nacimiento;


}
