package com.sena.financeCosmeticosBellezaInfinita.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.financeCosmeticosBellezaInfinita.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query("""
                SELECT c FROM Cliente c
                WHERE LOWER(CONCAT(c.primerNombre, ' ', c.segundoNombre, ' ', c.primerApellido, ' ', c.segundoApellido))
                      LIKE LOWER(CONCAT('%', :nombreCompleto, '%'))
            """)
    Page<Cliente> buscarPorNombreCompleto(@Param("nombreCompleto") String nombreCompleto, Pageable pageable);
}
