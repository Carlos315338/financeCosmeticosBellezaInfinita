package com.sena.financeCosmeticosBellezaInfinita.entity;

import java.math.BigDecimal;

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
@Table(name = "detalles_de_venta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetalleDeVenta {

    @Id
    @Column(name = "id_detalle", updatable = false, nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @Column(name = "id_producto")
    private String idProducto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio")
    private BigDecimal precio;

}

