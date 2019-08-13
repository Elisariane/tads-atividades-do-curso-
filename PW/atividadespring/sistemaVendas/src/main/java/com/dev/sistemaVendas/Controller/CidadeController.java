package com.dev.sistemaVendas.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.sistemaVendas.Model.Cidade;
import com.dev.sistemaVendas.Repository.CidadeRepository;

@Controller
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	// Método de listar as cidades
	@GetMapping("/cidade")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/cidadeLista");
		mv.addObject("cidade", cidadeRepository.findAll());
		
		return mv;
	}
	
	// Método para adicionar o estado
	@GetMapping("/addCidade")
	public ModelAndView add(Cidade cidade) {
		ModelAndView mv = new ModelAndView("/cidadeAdd");
		mv.addObject("cidade", cidade);
		
		return mv;
	}
	
	//Método para editar a cidade
	@GetMapping("/editarCidade/{id}")
	public ModelAndView edit(@PathVariable("id") Long id ) {
		
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		Cidade c = cidade.get();
	
		
		return add(c);
		
		
	}
	
	//Método para excluir a cidade 
	@GetMapping("/removerCidade/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		Optional<Cidade> cidade = cidadeRepository.findById(id);
		Cidade c = cidade.get();
		cidadeRepository.delete(c);
		return buscarTodos();
	}
	
	//Método de salvar cidade
	@PostMapping("/salvarCidade")
	public ModelAndView save(@Valid Cidade cidade, BindingResult result) {
		if(result.hasErrors()) {
			return add(cidade);
		}
		
		cidadeRepository.saveAndFlush(cidade);
		
		return buscarTodos();
	}
	
	
}
