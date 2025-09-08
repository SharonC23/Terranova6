package com.Terranovans.NS.entity;



import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "disponibilidad")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class disponibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisponibilidad;

    private LocalDateTime fecha;
    private LocalTime hora;
    private Boolean disponible;

    @ManyToOne
    @JoinColumn(name = "id_calendario", nullable = false)
    private calendario calendario;
}

