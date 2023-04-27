package com.bosonit.cabecera.domain;

import com.bosonit.cabecera.controller.dto.CabeceraFraOutputDto;
import com.bosonit.cliente.domain.Cliente;
import com.bosonit.linea.domain.LineaFra;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cabecera")
public class CabeceraFra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cabecera_fra")
    private int idCabeceraFra;
    @Column(name = "importe_fra")
    private double importeFra;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;
    @OneToMany(mappedBy = "cabeceraFra")
    private List<LineaFra> lineas;

    public CabeceraFra(int importeFra, Cliente cliente) {
        this.importeFra = importeFra;
        this.cliente = cliente;
    }
}
