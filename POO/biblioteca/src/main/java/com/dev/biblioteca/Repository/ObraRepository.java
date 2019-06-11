package com.dev.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.biblioteca.Model.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long> {

}
