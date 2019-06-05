package com.lisa.Elisariane.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lisa.Elisariane.Models.Palestra;
import com.lisa.Elisariane.Repository.PalestraRepository;

@Controller
public class PalestraController {

	@Autowired
	private PalestraRepository repoPalestra;
	
	@GetMapping("/palestra")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("palestra/listaPalestra");
		mv.addObject("palestras", repoPalestra.findAll());
		
		return mv;
	}
	
	@GetMapping("/addPalestra")
	public ModelAndView add(Palestra palestra) {
		
		ModelAndView mv = new ModelAndView("palestra/palestraCadastro");
		mv.addObject("palestra",palestra);
		
		return mv;
	}
	
	@GetMapping("/editarPalestra/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Palestra> palestra = repoPalestra.findById(id);
		Palestra p = palestra.get();
		
		
		return add(p);
	}
	
	@GetMapping("/removerPalestra/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		Optional<Palestra> palestra = repoPalestra.findById(id);
		Palestra p = palestra.get();
		repoPalestra.delete(p);
		
		return findAll();
	}
	
	@PostMapping("/salvarPalestra")
	public ModelAndView save(@Valid Palestra palestra, BindingResult resultado) {
		
		repoPalestra.save(palestra);
		
		return findAll();
}
}
