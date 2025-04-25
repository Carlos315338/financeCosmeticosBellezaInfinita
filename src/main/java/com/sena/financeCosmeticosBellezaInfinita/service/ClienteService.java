package com.sena.financeCosmeticosBellezaInfinita.service;

import org.springframework.data.domain.Page;

import com.sena.financeCosmeticosBellezaInfinita.dto.ClienteDTO;

public interface ClienteService {

    public Page<ClienteDTO> obtenerClientes(int page, int size);

}
