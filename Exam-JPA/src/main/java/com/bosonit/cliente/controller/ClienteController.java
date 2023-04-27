package com.bosonit.cliente.controller;

import ch.qos.logback.core.net.server.Client;
import com.bosonit.cliente.application.CLienteServiceImpl;
import com.bosonit.cliente.controller.dto.ClienteInputDto;
import com.bosonit.cliente.controller.dto.ClienteOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    CLienteServiceImpl cLienteServiceImpl;

    @PostMapping
    public ClienteOutputDto anadirCliente(@RequestBody ClienteInputDto clienteInputDto) {
        return cLienteServiceImpl.añadirCliente(clienteInputDto);
    }

    @GetMapping("/{id}")
    public ClienteOutputDto obtenerClientePorId(@PathVariable int id) {
        return cLienteServiceImpl.obtenerClientePorId(id);
    }

    @GetMapping
    public List<ClienteOutputDto> obtenerTodosLosClientes() {
        return cLienteServiceImpl.obtenerTodosLosClientes();
    }

    @PutMapping("/{id}")
    public ClienteOutputDto actualizarClientePorId(@PathVariable int id, @RequestBody ClienteInputDto clienteInputDto) {
        return cLienteServiceImpl.actualizarClientePorId(id, clienteInputDto);
    }

    @DeleteMapping("/{id}")
    public void eliminarClientePorId(@PathVariable int id) {
        cLienteServiceImpl.eliminarClientePorId(id);
    }
}
