package com.dev.atividadespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	//Quando accesar a url como resposta retornará a pagina index 
	@RequestMapping("/")
	public String IndexController() {
		return "index";
	}
	

}
