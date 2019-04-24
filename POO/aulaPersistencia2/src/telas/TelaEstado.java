package telas;

import java.util.Iterator;
import java.util.Scanner;

import dao.DaoEstado;
import entidade.Estado;

public class TelaEstado {

	
	public static void main(String[] args) {
		DaoEstado daoestado = new DaoEstado();
		Scanner entrada = new Scanner (System.in);
		boolean sair = false;
		while(sair == false){
			
		System.out.println("Selecione: \n1- Inserir\n2- Alterar\n3- Deletar \n4- Consultar");
		int op= 0;
		System.out.println("Escolha a opção: ");
		op= entrada.nextInt();
		entrada = new Scanner (System.in);
		
		if(op == 1) {
			Estado estado = new Estado();
			

			System.out.println("Nome do estado: ");
			String nome = entrada.nextLine();
			estado.setNome(nome);
			entrada = new Scanner (System.in);
			
			System.out.println("Sigla: ");
			String sigla = entrada.nextLine();
			estado.setSigla(sigla);
			entrada = new Scanner (System.in);
			
			daoestado.salvar(estado);
		}
		
		else if(op == 2) {
			Estado estado = new Estado();
			
			System.out.println("\r");
			for (Estado est : daoestado.consultar()) {
				System.out.println("Id: "+est.getIdest()+" Estado: "+est.getNome()+" - "+est.getSigla());
			}
			
			System.out.println("Id do estado: ");
			int id = entrada.nextInt();
			estado.setIdest(id);
			entrada = new Scanner (System.in);
			
			System.out.println("Nome do estado: ");
			String nome = entrada.nextLine();
			estado.setNome(nome);
			entrada = new Scanner (System.in);
			
			System.out.println("Sigla: ");
			String sigla = entrada.nextLine();
			estado.setSigla(sigla);
			entrada = new Scanner (System.in);
			
			daoestado.alterar(estado);
		}
		
		else if(op == 3) {
			Estado estado = new Estado();
			

			System.out.println("Nome do estado: ");
			String nome = entrada.nextLine();
			estado.setNome(nome);
			entrada = new Scanner (System.in);
			
			daoestado.delete(estado);
		}
		
		else if(op == 4) {
			System.out.println("\r");
			for (Estado estado : daoestado.consultar()) {
				System.out.println("Id: "+estado.getIdest()+" Estado: "+estado.getNome()+" - "+estado.getSigla());
			}
			System.out.println("\r");
			
			
		}
		
		else {
			sair = true;
		}
		}
	}

}
