package com.bosonit.cliente.application;

import com.bosonit.cliente.controller.dto.ClienteInputDto;
import com.bosonit.cliente.controller.dto.ClienteOutputDto;

import java.util.List;

public interface ClienteService {
    ClienteOutputDto añadirCliente(ClienteInputDto clienteInputDto);
    ClienteOutputDto obtenerClientePorId(int id);
    List<ClienteOutputDto> obtenerTodosLosClientes();
    ClienteOutputDto actualizarClientePorId(int id, ClienteInputDto clienteInputDto);
    void eliminarClientePorId(int id);
}
