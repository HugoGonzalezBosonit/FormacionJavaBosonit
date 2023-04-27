package com.bosonit.cabecera.application;

import com.bosonit.cabecera.controller.dto.CabeceraFraInputDto;
import com.bosonit.cabecera.controller.dto.CabeceraFraOutputDto;
import com.bosonit.linea.controller.dto.LineaFraInputDto;

import java.util.List;

public interface CabeceraFraService {
    CabeceraFraOutputDto añadirCabeceraFra(CabeceraFraInputDto cabeceraFraInputDto);
    CabeceraFraOutputDto obtenerCabeceraFraPorId(int id);
    List<CabeceraFraOutputDto> obtenerTodasLasCabecerasFra();
    CabeceraFraOutputDto actualizarCabeceraFraPorId(int id, CabeceraFraInputDto cabeceraFraInputDto);
    void eliminarCabeceraFraPorId(int id);
}
