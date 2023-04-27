package com.bosonit.cabecera.controller;

import com.bosonit.cabecera.application.CabeceraFraServiceImpl;
import com.bosonit.cabecera.controller.dto.CabeceraFraInputDto;
import com.bosonit.cabecera.controller.dto.CabeceraFraOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabeceraFactura")
public class CabeceraFraController {
    @Autowired
    CabeceraFraServiceImpl cabeceraFraServiceImpl;

    @PostMapping
    public CabeceraFraOutputDto añadirCabacera(@RequestParam CabeceraFraInputDto cabeceraFraInputDto) {
        return cabeceraFraServiceImpl.añadirCabeceraFra(cabeceraFraInputDto);
    }

    @GetMapping("/getById/{id}")
    public CabeceraFraOutputDto obtenerCabeceraPorId(@PathVariable int id) {
        return cabeceraFraServiceImpl.obtenerCabeceraFraPorId(id);
    }

    @GetMapping
    public ResponseEntity<List<CabeceraFraOutputDto>> obtenerTodasLasCabecerasFra() {
        return new ResponseEntity<>(cabeceraFraServiceImpl.obtenerTodasLasCabecerasFra(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public CabeceraFraOutputDto actualizarCabeceraFraPorId(@PathVariable int id, @RequestBody CabeceraFraInputDto cabeceraFraInputDto) {
        return cabeceraFraServiceImpl.actualizarCabeceraFraPorId(id, cabeceraFraInputDto);
    }

    @DeleteMapping("/factura/{id}")
    public void eliminarCabeceraFraPorId(@PathVariable int id) {
        cabeceraFraServiceImpl.eliminarCabeceraFraPorId(id);
    }
}

