package com.bosonit.cabecera.controller.dto;

import com.bosonit.cabecera.domain.CabeceraFra;
import com.bosonit.cliente.controller.dto.ClienteOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabeceraFraOutputDto {
    private int idCabeceraFra;
    private double importeFra;
    private ClienteOutputDto clienteOutputDto;

    public CabeceraFraOutputDto(CabeceraFra cabeceraFra) {
     setIdCabeceraFra(cabeceraFra.getIdCabeceraFra());
     setImporteFra(cabeceraFra.getImporteFra());
     setClienteOutputDto(new ClienteOutputDto(cabeceraFra.getCliente()));
    }
}
