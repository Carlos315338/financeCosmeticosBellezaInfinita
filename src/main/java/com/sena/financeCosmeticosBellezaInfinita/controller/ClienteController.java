package com.sena.financeCosmeticosBellezaInfinita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.financeCosmeticosBellezaInfinita.dto.ApiResponse;
import com.sena.financeCosmeticosBellezaInfinita.dto.ClienteDTO;
import com.sena.financeCosmeticosBellezaInfinita.entity.PaginacionFiltroDTO;
import com.sena.financeCosmeticosBellezaInfinita.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/clientes")
    public ResponseEntity<ApiResponse<Page<ClienteDTO>>> listarClientes(@RequestBody PaginacionFiltroDTO filtro) {
        Page<ClienteDTO> clientes = clienteService.obtenerClientes(filtro);
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", clientes));
    }

    @GetMapping("/cantidadCliente")
    public ResponseEntity<ApiResponse<Long>> cantidadClientes() {
        try {
            Long cantidadCliente = clienteService.cantidadClientes();
            return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", cantidadCliente));
        } catch (Exception e) {
            System.out.println("Error obtener la cantidad de  clientes " + e);
            return ResponseEntity.ok(ApiResponse.error(""));

        }
    }

    @PostMapping("updateCliente/{id}")
    public ResponseEntity<ApiResponse<ClienteDTO>> listarProveedores(@PathVariable String id, @RequestBody ClienteDTO cliente) {
        ClienteDTO productoUpdate = clienteService.actualizacionCliente(id, cliente);
        return ResponseEntity.ok(ApiResponse.ok("Operacion Exitosa", productoUpdate));
    }
}
