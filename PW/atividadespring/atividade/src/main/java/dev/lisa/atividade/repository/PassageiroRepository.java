package dev.lisa.atividade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lisa.atividade.models.Passageiro;



public interface PassageiroRepository extends JpaRepository<Passageiro, Long>{
	
		
	List<Passageiro> findByNome(String nome);	
}