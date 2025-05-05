package com.sena.financeCosmeticosBellezaInfinita.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sena.financeCosmeticosBellezaInfinita.dto.ClienteDTO;
import com.sena.financeCosmeticosBellezaInfinita.entity.Cliente;
import com.sena.financeCosmeticosBellezaInfinita.entity.PaginacionFiltroDTO;
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
    public Page<ClienteDTO> obtenerClientes(PaginacionFiltroDTO filtro) {
        Page<Cliente> clientes;
        List<Cliente> lista;

        if ("nombreCompleto".equalsIgnoreCase(filtro.getSortField())) {
            clientes = clienteRepository.buscarPorNombreCompleto(filtro.getNombre(), Pageable.unpaged());

            // Crear copia mutable antes de ordenar
            lista = new ArrayList<>(clientes.getContent());

            Comparator<Cliente> comparator = Comparator
                    .comparing(c -> ((c.getPrimerNombre() != null ? c.getPrimerNombre() : "") + " " +
                            (c.getSegundoNombre() != null ? c.getSegundoNombre() : "") + " " +
                            (c.getPrimerApellido() != null ? c.getPrimerApellido() : "") + " " +
                            (c.getSegundoApellido() != null ? c.getSegundoApellido() : "")).toLowerCase());

            if ("desc".equalsIgnoreCase(filtro.getSortOrder())) {
                comparator = comparator.reversed();
            }

            lista.sort(comparator);

            int start = Math.min(filtro.getPage() * filtro.getSize(), lista.size());
            int end = Math.min(start + filtro.getSize(), lista.size());
            lista = lista.subList(start, end);
        } else {
            clientes = clienteRepository.buscarPorNombreCompleto(
                    filtro.getNombre(),
                    PageRequest.of(filtro.getPage(), filtro.getSize(),
                            Sort.by(Sort.Direction.fromString(filtro.getSortOrder()), filtro.getSortField())));
            lista = new ArrayList<>(clientes.getContent()); // buena práctica por si acaso
        }

        List<ClienteDTO> clienteDTOs = clienteMapper.listClienteToListClienteDTO(lista);
        return new PageImpl<>(clienteDTOs, PageRequest.of(filtro.getPage(), filtro.getSize()),
                clientes.getTotalElements());
    }

    @Override
    public Long cantidadClientes() {
        return clienteRepository.count();
    }

    @Override
    public ClienteDTO actualizacionCliente(String id, ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));

        clienteExistente.setIdentificacion(clienteDTO.getIdentificacion());
        clienteExistente.setPrimerNombre(clienteDTO.getPrimerNombre());
        clienteExistente.setSegundoNombre(clienteDTO.getSegundoNombre());
        clienteExistente.setPrimerApellido(clienteDTO.getPrimerApellido());
        clienteExistente.setSegundoApellido(clienteDTO.getSegundoApellido());
        clienteExistente.setCorreoElectronico(clienteDTO.getCorreoElectronico());
        clienteExistente.setTelefono(clienteDTO.getTelefono());

        Cliente actualizado = clienteRepository.save(clienteExistente);
        return clienteMapper.clienteToClienteDTO(actualizado);
    }

}
