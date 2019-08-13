package com.dev.sistemaVendas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.sistemaVendas.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
