package com.dev.biblioteca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.biblioteca.Model.Departamento;
import com.dev.biblioteca.Model.Editora;
import com.dev.biblioteca.Repository.EditoraRepository;

@Controller
public class EditoraController {

	@Autowired
	private EditoraRepository editrepositorio;
	
	@RequestMapping("/editora")
	public String editora() {
		return "cadastroEditora";
	}
	
	@RequestMapping(value = "/cadastrarEditora", method = RequestMethod.POST)
	public String inserir(Editora editora) {
		editrepositorio.save(editora);
	 return "redirect:/editora";
	}
	
//	@RequestMapping(value="/editoraList")
//	public ModelAndView listaeditora() {
//		ModelAndView mv = new ModelAndView("deptoList");
//		List<Departamento> depto = deptopositorio.findAll();
//		mv.addObject("deptos", depto);
//		return mv;
//	}



}
