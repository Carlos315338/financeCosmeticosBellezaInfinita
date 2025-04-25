package com.sena.financeCosmeticosBellezaInfinita.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class PagoDTO {

    private String id;
    private VentaDTO venta;
    private MetodoDePagoDTO metodoDePago;
    private BigDecimal montoPago;
    private LocalDateTime fechaPago;
    private String transaccionId; 

}
