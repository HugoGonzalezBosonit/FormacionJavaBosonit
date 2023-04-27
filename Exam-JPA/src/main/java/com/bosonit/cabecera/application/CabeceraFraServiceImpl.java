package com.bosonit.cabecera.application;

import com.bosonit.cabecera.controller.dto.CabeceraFraInputDto;
import com.bosonit.cabecera.controller.dto.CabeceraFraOutputDto;
import com.bosonit.cabecera.domain.CabeceraFra;
import com.bosonit.cabecera.repository.CabeceraFraRepository;
import com.bosonit.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabeceraFraServiceImpl implements CabeceraFraService{
    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public CabeceraFra cabeceraFraInputDtoToEntity(CabeceraFraInputDto cabeceraFraInputDto) {
        CabeceraFra cabeceraFra = new CabeceraFra();

        cabeceraFra.setImporteFra(cabeceraFraInputDto.getImporteFra());
        cabeceraFra.setCliente(clienteRepository.findById(cabeceraFraInputDto.getIdCliente()).orElseThrow());

        return cabeceraFra;
    }

    @Override
    public CabeceraFraOutputDto añadirCabeceraFra(CabeceraFraInputDto cabeceraFraInputDto) {
        CabeceraFra cabeceraFra = cabeceraFraInputDtoToEntity(cabeceraFraInputDto);

        cabeceraFraRepository.save(cabeceraFra);

        return new CabeceraFraOutputDto(cabeceraFra);
    }

    @Override
    public CabeceraFraOutputDto obtenerCabeceraFraPorId(int id) {
        CabeceraFra cabeceraFra = cabeceraFraRepository.findById(id).orElseThrow();

        return new CabeceraFraOutputDto(cabeceraFra);
    }

    @Override
    public List<CabeceraFraOutputDto> obtenerTodasLasCabecerasFra() {
        List<CabeceraFra> cabecerasFra = cabeceraFraRepository.findAll();

        return cabecerasFra.stream().map(CabeceraFraOutputDto::new).toList();
    }

    @Override
    public  CabeceraFraOutputDto actualizarCabeceraFraPorId(int id, CabeceraFraInputDto cabeceraFraInputDto) {
        CabeceraFra cabeceraFra = cabeceraFraRepository.findById(id).orElseThrow();

        cabeceraFra.setImporteFra(cabeceraFraInputDto.getImporteFra());
        cabeceraFra.setCliente(clienteRepository.findById(cabeceraFraInputDto.getIdCliente()).orElseThrow());

        return new CabeceraFraOutputDto(cabeceraFra);
    }

    @Override
    public void eliminarCabeceraFraPorId(int id) {
        cabeceraFraRepository.delete(cabeceraFraRepository.findById(id).orElseThrow());
    }

}
