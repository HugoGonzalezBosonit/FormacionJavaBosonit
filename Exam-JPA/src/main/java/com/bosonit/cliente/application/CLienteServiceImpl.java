package com.bosonit.cliente.application;

import com.bosonit.cliente.controller.dto.ClienteInputDto;
import com.bosonit.cliente.controller.dto.ClienteOutputDto;
import com.bosonit.cliente.domain.Cliente;
import com.bosonit.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CLienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente clienteInputDtoToEntity(ClienteInputDto clienteInputDto) {
        Cliente cliente = new Cliente();
        cliente.setNombreCliente(clienteInputDto.getNombreCliente());
        return cliente;
    }

    @Override
    public ClienteOutputDto añadirCliente(ClienteInputDto clienteInputDto) {
        Cliente cliente = clienteInputDtoToEntity(clienteInputDto);

        clienteRepository.save(cliente);

        return new ClienteOutputDto(cliente);
    }

    @Override
    public ClienteOutputDto obtenerClientePorId(int id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();

        return new ClienteOutputDto(cliente);
    }

    @Override
    public List<ClienteOutputDto> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream().map(ClienteOutputDto::new).toList();
    }

    @Override
    public ClienteOutputDto actualizarClientePorId(int id, ClienteInputDto clienteInputDto) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNombreCliente((clienteInputDto.getNombreCliente()));

        clienteRepository.save(cliente);

        return new ClienteOutputDto();
    }

    @Override
    public void eliminarClientePorId(int id) {
        clienteRepository.delete(clienteRepository.findById(id).orElseThrow());
    }








}
