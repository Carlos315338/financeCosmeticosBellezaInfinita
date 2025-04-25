package com.sena.financeCosmeticosBellezaInfinita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.financeCosmeticosBellezaInfinita.dto.ApiResponse;
import com.sena.financeCosmeticosBellezaInfinita.dto.ClienteDTO;
import com.sena.financeCosmeticosBellezaInfinita.service.ClienteService;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<ApiResponse<Page<ClienteDTO>>> listarClientes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<ClienteDTO> clientes = clienteService.obtenerClientes(page, size);
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", clientes) );
    }

}
