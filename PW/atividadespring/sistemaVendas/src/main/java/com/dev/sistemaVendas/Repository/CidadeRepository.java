package com.dev.sistemaVendas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.sistemaVendas.Model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
