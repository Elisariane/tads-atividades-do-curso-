package com.dev.cadastroCliente.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.cadastroCliente.Models.Curriculo;

@Controller
public class CastatroClienteController {

/*	@RequestMapping("/visualizar")
	public String cadastro() {
		// Retorna o conteudo da pagina html
		return "vizualizar";

	}*/
	
	@RequestMapping(value ="/vizualizar", method=RequestMethod.POST)
	public ModelAndView vizualizar(Curriculo curriculo) {
	ModelAndView mv = new ModelAndView("vizualizar");	
	mv.addObject("curriculo", curriculo);
	return mv;
		
	}

}
