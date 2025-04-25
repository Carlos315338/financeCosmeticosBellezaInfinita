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
public class VentaDTO {

    private String id;
    private ClienteDTO cliente;
    private BigDecimal montoTotal;
    private LocalDateTime fechaVenta;
    private String estado;

}
