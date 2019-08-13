package com.dev.sistemaVendas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.sistemaVendas.Model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}
