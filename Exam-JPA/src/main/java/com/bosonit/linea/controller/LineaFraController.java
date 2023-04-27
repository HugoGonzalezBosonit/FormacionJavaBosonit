package com.bosonit.linea.controller;

import com.bosonit.linea.application.LineaFraServiceImpl;
import com.bosonit.linea.controller.dto.LineaFraInputDto;
import com.bosonit.linea.controller.dto.LineaFraOutputDto;
import com.bosonit.linea.domain.LineaFra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lineaFactura")
public class LineaFraController {
    @Autowired
    LineaFraServiceImpl lineaFraServiceImpl;

    @PostMapping("/addLinea")
    public LineaFraOutputDto añadirLinea(@RequestBody LineaFraInputDto lineaFraInputDto) {
        return lineaFraServiceImpl.añadirLineaFra(lineaFraInputDto);
    }

    @GetMapping("/{id}")
    public LineaFraOutputDto obtenerLineaFraPorId(@PathVariable int id) {
        return lineaFraServiceImpl.obtenerLineaFraPorId(id);
    }

    @GetMapping
    public List<LineaFraOutputDto> obtenerTodasLasLineas() {
        return lineaFraServiceImpl.obtenerTodasLasLineas();
    }

    @PutMapping("/{id}")
    public LineaFraOutputDto actualizarLineaFraPorId(@PathVariable int id, @RequestBody LineaFraInputDto lineaFraInputDto) {
        return lineaFraServiceImpl.actualizarLineaFraPorId(id, lineaFraInputDto);
    }

    @DeleteMapping("/{id}")
    public void eliminarLineaFraPorId(@PathVariable int id) {
        lineaFraServiceImpl.eliminarLineaFraPorId(id);
    }

}
