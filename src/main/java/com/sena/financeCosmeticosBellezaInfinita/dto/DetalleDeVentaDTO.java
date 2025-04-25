package com.sena.financeCosmeticosBellezaInfinita.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetalleDeVentaDTO {

    private String id;
    private VentaDTO venta;
    private String idProducto;
    private int cantidad;
    private BigDecimal precio;

}
