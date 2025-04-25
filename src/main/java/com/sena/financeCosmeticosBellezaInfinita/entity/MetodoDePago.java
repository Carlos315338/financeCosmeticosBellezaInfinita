package com.sena.financeCosmeticosBellezaInfinita.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "metodos_de_pago")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MetodoDePago {

    @Id
    @Column(name = "id_metodo_de_pago", updatable = false, nullable = false)
    private String id;

    @Column(name = "nombre_metodo", nullable = false, unique = true)
    private String nombre;

}

