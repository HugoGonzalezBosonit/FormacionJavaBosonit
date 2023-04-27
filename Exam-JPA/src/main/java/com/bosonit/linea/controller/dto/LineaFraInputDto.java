package com.bosonit.linea.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaFraInputDto {
    private String nombreProducto;
    private double precio;
    private double cantidad;
    private int idCabaceraFra;
}
