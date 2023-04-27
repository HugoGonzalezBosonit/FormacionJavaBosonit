package com.bosonit.cliente.domain;

import com.bosonit.cabecera.domain.CabeceraFra;
import com.bosonit.cliente.controller.dto.ClienteOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private int idCliente;
    @Column(name = "nombre_cliente", length = 100, nullable = false)
    private String nombreCliente;
    @OneToMany(mappedBy = "cliente")
    private List<CabeceraFra> cabeceras;

    public Cliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public ClienteOutputDto clienteToClienteOutputDto(){
        return new ClienteOutputDto(this.idCliente, this.nombreCliente);
    }
}
