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

import com.dev.sistemaVendas.Model.Cliente;
import com.dev.sistemaVendas.Repository.CidadeRepository;
import com.dev.sistemaVendas.Repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping("/cliente")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/listaCliente");
		mv.addObject("clientes", repository.findAll());
		
		return mv;
	}
	
	@GetMapping("/addCliente")
	public ModelAndView add(Cliente cliente) {
		
		ModelAndView mv = new ModelAndView("/clienteAdd");
		mv.addObject("cliente", cliente);
		mv.addObject("cidades", cidadeRepository.findAll());
		return mv;
	}
	
	@GetMapping("/editarCliente/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Cliente> cliente = repository.findById(id);
		Cliente c = cliente.get();	
		
		return add(c);
	}
	
	@GetMapping("/removerCliente/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Cliente> cliente = repository.findById(id);
		Cliente c = cliente.get();	
		
		repository.delete(c);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarCliente")
	public ModelAndView save(@Valid Cliente cliente, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(cliente);
		}
		
		repository.saveAndFlush(cliente);
		
		return buscarTodos();
	}
	
}