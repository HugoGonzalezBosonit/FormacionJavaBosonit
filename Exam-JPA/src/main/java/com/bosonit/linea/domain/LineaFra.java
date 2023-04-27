package com.bosonit.linea.domain;

import com.bosonit.cabecera.domain.CabeceraFra;
import com.bosonit.linea.controller.dto.LineaFraInputDto;
import com.bosonit.linea.controller.dto.LineaFraOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "linea")
public class LineaFra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_linea")
    private int idLineaFra;
    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;
    @Column(name = "precio")
    private double precio;
    @Column(name = "cantidad")
    private double cantidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cabecera_fra")
    private CabeceraFra cabeceraFra;

    public LineaFra(String nombreProducto, double precio, double cantidad, CabeceraFra cabeceraFra) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.cabeceraFra = cabeceraFra;
    }
}
