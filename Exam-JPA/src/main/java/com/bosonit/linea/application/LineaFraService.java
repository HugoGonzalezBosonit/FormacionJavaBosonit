package com.bosonit.linea.application;

import com.bosonit.linea.controller.dto.LineaFraInputDto;
import com.bosonit.linea.controller.dto.LineaFraOutputDto;

import java.util.List;

public interface LineaFraService {
    LineaFraOutputDto añadirLineaFra(LineaFraInputDto lineaFraInputDto);
    LineaFraOutputDto obtenerLineaFraPorId(int id);
    List<LineaFraOutputDto> obtenerTodasLasLineas();
    LineaFraOutputDto actualizarLineaFraPorId(int id, LineaFraInputDto lineaFraInputDto);
    void eliminarLineaFraPorId(int id);
}
