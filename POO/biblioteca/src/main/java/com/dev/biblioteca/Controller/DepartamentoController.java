package com.dev.biblioteca.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.biblioteca.Model.Departamento;
import com.dev.biblioteca.Repository.DepartamentoRepository;



@Controller
public class DepartamentoController {
	@Autowired
	private DepartamentoRepository deptopositorio;
	
	@RequestMapping("/departamento")
	public String editora() {
		return "cadastroDepartamento";
	}
	
	@RequestMapping(value = "/cadastrarDepartamento", method = RequestMethod.POST)
	public String inserir(Departamento depto) {
		deptopositorio.save(depto);
//		if(depto.getId() != null) {
//			return "redirect:/deptoList";
//		}
	 return "redirect:/departamento";
	}
	
	
	@RequestMapping(value="/deptoList")
	public ModelAndView listadepto() {
		ModelAndView mv = new ModelAndView("deptoList");
		List<Departamento> depto = deptopositorio.findAll();
		mv.addObject("deptos", depto);
		return mv;
	}
	
	@RequestMapping(value="/excluirDepto")
	public String apaga(Long id) {
		deptopositorio.deleteById(id);
		return "redirect:/deptoList";
	}
	
	@RequestMapping(value="/editarDepto")
	public ModelAndView editar(Long id) {
		ModelAndView mv = new ModelAndView("deptoList");
		Optional<Departamento> deptoedit = deptopositorio.findById(id);
		mv.addObject("deptoedit", deptoedit.get());
		List<Departamento> deptos = deptopositorio.findAll();
		mv.addObject("deptos", deptos);
		return mv;
	}



}
