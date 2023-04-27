package com.bosonit.cabecera.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabeceraFraInputDto {
    private double importeFra;
    private int idCliente;
}
