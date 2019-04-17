package com.dev.cadastroCliente.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	//Metodo que retorna o caminho da pagina principal
@RequestMapping("/")
public String index() {
	//Retorna o conteudo da pagina html 
	return "index";
	
}



}
