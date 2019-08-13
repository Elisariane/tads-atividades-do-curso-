package com.dev.sistemaVendas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.sistemaVendas.Model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
