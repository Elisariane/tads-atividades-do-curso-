package com.lisa.projetoAgenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SalvarController {

	//A anotação @ Autowired fornece controle sobre onde e como a ligação entre os beans deve ser realizada. 
	@Autowired
	private DaoAgente agente;
}
