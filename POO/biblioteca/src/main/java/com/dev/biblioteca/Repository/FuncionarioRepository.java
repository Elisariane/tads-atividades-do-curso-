package com.dev.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.biblioteca.Model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
