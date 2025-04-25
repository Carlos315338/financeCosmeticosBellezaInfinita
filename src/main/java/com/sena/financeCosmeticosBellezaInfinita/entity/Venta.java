package com.sena.financeCosmeticosBellezaInfinita.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ventas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Venta {

    @Id
    @Column(name = "id_venta", updatable = false, nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;

    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;

    @Column(name = "estado_venta")
    private String estado;

}

