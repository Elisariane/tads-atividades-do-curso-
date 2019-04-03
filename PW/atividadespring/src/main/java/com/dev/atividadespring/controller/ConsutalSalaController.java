package com.dev.atividadespring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.atividadespring.models.AtributoConsultarSala;

@Controller
public class ConsutalSalaController {

	
	@RequestMapping("/consultarsala")
	public String consultarsala() {
		return "consultarsala";
	}
	

	@RequestMapping(value = "/consultarsala", method = RequestMethod.POST  )
	public ModelAndView conferir(AtributoConsultarSala atributo) {
		AtributoConsultarSala var = new AtributoConsultarSala();
		
		ModelAndView mv = new ModelAndView("consultarsala");
		mv.addObject("nomeAluno", var.getNome());	
		int sala = 0;
		if(var.getCurso().equals("1")) {
			sala = 22;
		
		}
//		else if(curso.equals(2)) {
//			sala = "Sala 21";
//			mv.addObject("sala", sala);	
//		}
//		
//		else if(curso.equals(3)) {
//			String lista[] = new String[] {"A","B","C","D","E", "F","G", "H", "I", "J", "K"}; 
//			java.util.List<String> list = Arrays.asList(lista); 
//			
//			if(nome.charAt(0) == list ) {
//				
//			}
//		}
		mv.addObject("sala", sala);	
		return mv;
	}
	
	
}
