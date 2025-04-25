package com.sena.financeCosmeticosBellezaInfinita.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.sena.financeCosmeticosBellezaInfinita.dto.ClienteDTO;
import com.sena.financeCosmeticosBellezaInfinita.entity.Cliente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

    public ClienteDTO clienteToClienteDTO(Cliente cliente);

    public Cliente clienteDTOToCliente(ClienteDTO clienteDTO);

    List<ClienteDTO> listClienteToListClienteDTO(List<Cliente> clientes);

    List<Cliente> listClienteDTOToListCliente(List<ClienteDTO> clientesDtos);
}
