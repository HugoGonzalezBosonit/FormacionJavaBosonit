package com.bosonit.linea.application;

import com.bosonit.cabecera.repository.CabeceraFraRepository;
import com.bosonit.linea.controller.dto.LineaFraInputDto;
import com.bosonit.linea.controller.dto.LineaFraOutputDto;
import com.bosonit.linea.domain.LineaFra;
import com.bosonit.linea.repository.LineaFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineaFraServiceImpl implements LineaFraService{
    @Autowired
    LineaFraRepository lineaFraRepository;

    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    public LineaFra lineaFraInputDtoToEntity(LineaFraInputDto lineaFraInputDto) {
        LineaFra lineaFra = new LineaFra();

        lineaFra.setNombreProducto(lineaFraInputDto.getNombreProducto());
        lineaFra.setPrecio(lineaFraInputDto.getPrecio());
        lineaFra.setCantidad(lineaFraInputDto.getCantidad());
        lineaFra.setCabeceraFra(cabeceraFraRepository.findById(lineaFraInputDto.getIdCabaceraFra()).orElseThrow());

        return lineaFra;
    }

    @Override
    public LineaFraOutputDto añadirLineaFra(LineaFraInputDto lineaFraInputDto) {
        LineaFra lineaFra = lineaFraInputDtoToEntity(lineaFraInputDto);

        lineaFraRepository.save(lineaFra);

        return new LineaFraOutputDto(lineaFra);
    }

    @Override
    public LineaFraOutputDto obtenerLineaFraPorId(int id) {
        LineaFra lineaFra = lineaFraRepository.findById(id).orElseThrow();

        return new LineaFraOutputDto(lineaFra);
    }

    @Override
    public List<LineaFraOutputDto> obtenerTodasLasLineas() {
        List<LineaFra> lineasFra = lineaFraRepository.findAll();

        return lineasFra.stream().map(LineaFraOutputDto::new).toList();
    }

    @Override
    public LineaFraOutputDto actualizarLineaFraPorId(int id, LineaFraInputDto lineaFraInputDto) {
        LineaFra lineaFra = lineaFraRepository.findById(id).orElseThrow();

        lineaFra.setNombreProducto(lineaFraInputDto.getNombreProducto());
        lineaFra.setPrecio(lineaFraInputDto.getPrecio());
        lineaFra.setCantidad(lineaFraInputDto.getCantidad());
        lineaFra.setCabeceraFra(cabeceraFraRepository.findById(lineaFraInputDto.getIdCabaceraFra()).orElseThrow());

        return new LineaFraOutputDto(lineaFra);
    }

    @Override
    public void eliminarLineaFraPorId(int id) {
        lineaFraRepository.delete(lineaFraRepository.findById(id).orElseThrow());
    }
}
