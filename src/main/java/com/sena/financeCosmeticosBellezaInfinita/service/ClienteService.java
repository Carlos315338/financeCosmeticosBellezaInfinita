package com.sena.financeCosmeticosBellezaInfinita.service;

import org.springframework.data.domain.Page;

import com.sena.financeCosmeticosBellezaInfinita.dto.ClienteDTO;
import com.sena.financeCosmeticosBellezaInfinita.entity.PaginacionFiltroDTO;

public interface ClienteService {

    public Page<ClienteDTO> obtenerClientes(PaginacionFiltroDTO filtro);

    public Long cantidadClientes();

    public ClienteDTO actualizacionCliente(String id, ClienteDTO cliente);
}
