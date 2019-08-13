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

import com.dev.sistemaVendas.Model.Estado;
import com.dev.sistemaVendas.Repository.EstadoRepository;

@Controller
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	
	@GetMapping("/estado")
	public ModelAndView buscarTodos() {

		ModelAndView mv = new ModelAndView("/estadoLista");
		mv.addObject("estados", estadoRepository.findAll());

		return mv;
	}

	// Método para adicionar o estado
	@GetMapping("/addEstado")
	public ModelAndView add(Estado estado) {

		ModelAndView mv = new ModelAndView("/estadoAdd");
		mv.addObject("estado", estado);

		return mv;
	}

	//Método de editar o estado
	@GetMapping("/editarEstado/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		Optional<Estado> estado = estadoRepository.findById(id);
		Estado e = estado.get();

		return add(e);
	}

	// Método de excluir o estado
	@GetMapping("/removerEstado/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		Optional<Estado> estado = estadoRepository.findById(id);
		Estado e = estado.get();
		estadoRepository.delete(e);

		return buscarTodos();
	}

	// Método de salvar o Estado 
	@PostMapping("/salvarEstado")
	public ModelAndView save(@Valid Estado estado, BindingResult result) {

		if (result.hasErrors()) {
			return add(estado);
		}

		estadoRepository.saveAndFlush(estado);

		return buscarTodos();
	}

}
