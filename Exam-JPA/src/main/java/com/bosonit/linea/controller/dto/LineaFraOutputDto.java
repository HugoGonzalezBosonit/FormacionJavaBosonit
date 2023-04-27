package com.bosonit.linea.controller.dto;

import com.bosonit.cabecera.controller.dto.CabeceraFraOutputDto;
import com.bosonit.linea.domain.LineaFra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaFraOutputDto {
    private int idLineaFra;
    private String nombreProducto;
    private double precio;
    private double cantidad;
    private CabeceraFraOutputDto cabeceraFraOutputDto;

    public LineaFraOutputDto(LineaFra lineaFra) {
        setIdLineaFra(lineaFra.getIdLineaFra());
        setNombreProducto(lineaFra.getNombreProducto());
        setPrecio(lineaFra.getPrecio());
        setCantidad(lineaFra.getCantidad());
        setCabeceraFraOutputDto(new CabeceraFraOutputDto(lineaFra.getCabeceraFra()));
    }
}
