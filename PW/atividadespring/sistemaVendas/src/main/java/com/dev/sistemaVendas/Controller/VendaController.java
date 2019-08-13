package com.dev.sistemaVendas.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.sistemaVendas.Model.Cliente;
import com.dev.sistemaVendas.Model.ItensVenda;
import com.dev.sistemaVendas.Model.Produto;
import com.dev.sistemaVendas.Model.Venda;
import com.dev.sistemaVendas.Repository.ClienteRepository;
import com.dev.sistemaVendas.Repository.ItensVendaRepository;
import com.dev.sistemaVendas.Repository.ProdutoRepository;
import com.dev.sistemaVendas.Repository.VendaRepository;

@Controller
public class VendaController {


	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private ItensVendaRepository itensVendaRepository;

	
	
	private Venda venda = new Venda();// Instanciando um objeto venda
	private ItensVenda itensVenda = new ItensVenda(); // Instanciando um objeto itensVenda

	// Criando uma lista de itensVenda para adcionar todos os produtos que forem
	// comprados na venda
	private List<ItensVenda> listaItensVenda = new ArrayList<>();

	// @GetMapping("/categoria")
	// public ModelAndView buscarTodos() {
	//
	// ModelAndView mv = new ModelAndView("/categoriaPost");
	// mv.addObject("categorias", repository.findAll());
	//
	// return mv;
	// }

	// Método para adicionar a venda
	@GetMapping("/addVenda")
	public ModelAndView add() {

		ModelAndView mv = new ModelAndView("/vendaAdd");
		mv.addObject("venda", this.venda);// recebe o objeto que criamos acima
		mv.addObject("itensVenda", this.itensVenda);// recebe o objeto que criamos acima
		
//		List<Produto> produto = produtoRepository.findAll();
//		mv.addObject("produto", produto );
		return mv;
	}

	// @GetMapping("/editarCategoria/{id}")
	// public ModelAndView edit(@PathVariable("id") Long id) {
	//
	// Optional<Categoria> categoria = repository.findById(id);
	// Categoria e = categoria.get();
	//
	// return add(e);
	// }

	// @GetMapping("/removerCategoria/{id}")
	// public ModelAndView delete(@PathVariable("id") Long id) {
	//
	// Optional<Categoria> categoria = repository.findById(id);
	// Categoria e = categoria.get();
	// repository.delete(e);
	//
	// return buscarTodos();
	// }

	// Método de salvar a venda
	@PostMapping("/inserirSalvarVenda")
	// Recebe como parametro tanto a venda quanto o itensVenda
	public ModelAndView save(@Valid Venda venda, @Valid ItensVenda itensVenda, BindingResult result, String acao) {

		this.venda = venda;// this.venda (ou seja o objeto venda vai receber venda)

		// If que é responsavel em fazer a comparação do name inserido nos botões
		// Se a ação for igual ao th:value=item
		if (acao.equals("item")) {
			// Adicionando o produto na lista de itensVenda
			listaItensVenda.add(itensVenda);
		} else if (acao.equals("salvar")) { //Se ação tiver o th:value= salvar 
			
			this.venda.setDataVenda(new Date());//O obejeto venda recebe a data atual
			vendaRepository.saveAndFlush(this.venda);//vendarepository vai salvar o obejeto venda
			
			//Esse for nos permite que cada produto de ItensVenda:
			//1- tenha baixa no estoque quando a venda for finalizada
			//2- calcular o valor total da venda em um atributo valorTotal na classe venda

			
			for (ItensVenda it : listaItensVenda) {
				//1- tenha baixa no estoque quando a venda for finalizada
				it.getProduto().setQuantidadeEstoque(it.getProduto().getQuantidadeEstoque() - it.getQuantidade());
				produtoRepository.saveAndFlush(it.getProduto());

				//2- calcular o valor total da venda em um atributo valorTotal na classe venda
				it.getVenda().setValorTotalVenda(it.getVenda().getValorTotalVenda()+( it.getQuantidade()*it.getValorUnitario()));
				vendaRepository.saveAndFlush(it.getVenda());
				
				//inserindo esse item no objeto venda
				it.setVenda(this.venda);
				itensVendaRepository.saveAndFlush(it);//salvando o item
			}
			this.venda = new Venda();//instanciando n ovamente para "limpar" o objeto
			this.listaItensVenda = new ArrayList<>();//instanciando n ovamente para "limpar" o objeto
		}

		/*
		 * System.out.println("Quantidade Itens: " + listaItensVenda.size());
		 * System.out.println(this.venda.getObservacao());
		 * System.out.println(itensVenda.getQuantidade());
		 */
		return add();
	}

}
