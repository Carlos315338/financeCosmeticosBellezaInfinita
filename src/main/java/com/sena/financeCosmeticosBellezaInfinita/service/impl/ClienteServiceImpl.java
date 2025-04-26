package com.sena.financeCosmeticosBellezaInfinita.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sena.financeCosmeticosBellezaInfinita.dto.ClienteDTO;
import com.sena.financeCosmeticosBellezaInfinita.entity.Cliente;
import com.sena.financeCosmeticosBellezaInfinita.mapper.ClienteMapper;
import com.sena.financeCosmeticosBellezaInfinita.repository.ClienteRepository;
import com.sena.financeCosmeticosBellezaInfinita.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public Page<ClienteDTO> obtenerClientes(int page, int size) {

        Page<Cliente> clientes = clienteRepository.findAll(PageRequest.of(page, size));

        List<ClienteDTO> clienteDTOs = clienteMapper.listClienteToListClienteDTO(clientes.toList());

        Page<ClienteDTO> clientepage = new PageImpl<>(
                clienteDTOs,
                PageRequest.of(page, size),
                clientes.getTotalElements());

        return clientepage;
    }

    @Override
    public Long cantidadClientes() {
        return clienteRepository.count();
    }
}
