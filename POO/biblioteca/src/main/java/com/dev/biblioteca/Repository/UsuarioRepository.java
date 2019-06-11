package com.dev.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.biblioteca.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

}
