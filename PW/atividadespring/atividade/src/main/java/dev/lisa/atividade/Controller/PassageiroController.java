package dev.lisa.atividade.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import dev.lisa.atividade.models.Passageiro;
import dev.lisa.atividade.repository.PassageiroRepository;


@Controller
public class PassageiroController {

		@Autowired
		private PassageiroRepository passageiroRepository;

		@RequestMapping(value = "/")
		public String index() {	
			
			return "index";
		}
		
		@RequestMapping(value = "/validarBagagem", method = RequestMethod.GET)
		public String eventos() {	
			
			return "index";
		}
		
		
		@RequestMapping(value = "/validarBagagem", method = RequestMethod.POST)
		public String form(Passageiro pass) {
			
			if(!pass.validarBagagem()) {
				if(pass.getTipoVoo() == 'I')
					pass.setValorTaxa(280);
				else
					pass.setValorTaxa(140);
			} else
				pass.setValorTaxa(0);
			 passageiroRepository.save(pass);
			return "redirect:/validarBagagem";
		}

		@RequestMapping(value="/listaPassageiro")
		public ModelAndView listaEventos() {
			ModelAndView mv = new ModelAndView("listaPassageiro");
			List<Passageiro> passageiros = passageiroRepository.findAll();
			mv.addObject("passageiros", passageiros);
			return mv;
		}
		
}
