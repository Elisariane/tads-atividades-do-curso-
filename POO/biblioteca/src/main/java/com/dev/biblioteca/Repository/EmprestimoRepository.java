package com.dev.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.biblioteca.Model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
