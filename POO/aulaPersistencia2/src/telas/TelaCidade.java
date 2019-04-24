package telas;

import java.util.List;
import java.util.Scanner;

import dao.DaoCidade;
import dao.DaoEstado;
import entidade.Cidade;
import entidade.Estado;

public class TelaCidade {

	public static void main(String[] args) {
		DaoCidade daocidade = new DaoCidade();
		Scanner entrada = new Scanner (System.in);
		boolean sair = false;
		while(sair == false){
			
		System.out.println("Selecione: \n1- Inserir\n2- Alterar\n3- Deletar \n4- Consultar");
		
		int op= 0;
		System.out.println("Escolha a opção: ");
		op= entrada.nextInt();
		entrada = new Scanner (System.in);
		
		if(op == 1 ) {
			Cidade cidade = new Cidade();
			System.out.println("Nome da cidade: ");
			String nome = entrada.nextLine();
			cidade.setNome(nome);
			entrada = new Scanner (System.in);

			DaoEstado daoestado = new DaoEstado();
			List<Estado> lista = daoestado.consultar();
			for (Estado est : lista) {
				System.out.println("Id: "+est.getIdest()+" Estado: "+est.getNome()+" - "+est.getSigla());
			}
			int id = entrada.nextInt();

			Estado estado = new Estado();
			estado.setIdest(id);
			entrada = new Scanner (System.in);
			cidade.setEstado(lista.get(lista.indexOf(estado)));
			
			daocidade.salvar(cidade);
		}
		
	}
	
	}
}