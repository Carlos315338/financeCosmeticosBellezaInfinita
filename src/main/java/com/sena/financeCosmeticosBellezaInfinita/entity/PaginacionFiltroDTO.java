package com.sena.financeCosmeticosBellezaInfinita.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaginacionFiltroDTO {

    @NotNull
    private Integer page;

    @NotNull
    private Integer size;

    @NotBlank
    private String sortField;

    @NotBlank
    private String sortOrder;

    @NotNull
    private String nombre;

}

