package com.Terranovans.NS.dto;

import lombok.Data;

@Data
public class CompraDTO {

    private Long id;
    private Long compradorId;
    private Long productoId;
    private int cantidad;
    private Double total;
}
