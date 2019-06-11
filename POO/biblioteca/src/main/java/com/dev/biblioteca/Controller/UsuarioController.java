package com.dev.biblioteca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.biblioteca.Model.Departamento;
import com.dev.biblioteca.Model.Usuario;
import com.dev.biblioteca.Repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usurepositorio;
	
	@RequestMapping("/usuario")
	public String usuario() {
		return "cadastroUsuario";
	}
	
	@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
	public String inserir(Usuario usuario) {
		usurepositorio.save(usuario);
	 return "redirect:/usuario";
	}
	@RequestMapping(value="/usuarioList")
	public ModelAndView listausuario() {
		ModelAndView mv = new ModelAndView("usuarioList");
		List<Usuario> usuario= usurepositorio.findAll();
		mv.addObject("usuarios", usuario);
		return mv;
	}

	
//	@RequestMapping(value="/excluir")
//	public String apaga(Long id) {
//		usurepositorio.deleteById(id);
//		return "redirect:/potatoList";
//	}

	
}
