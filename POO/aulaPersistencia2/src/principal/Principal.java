package principal;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.DaoEstado;
import entidade.Estado;

public class Principal {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);

		Estado estado = new Estado();
		Estado teste = new Estado();

		System.out.println("Nome do estado: ");
		String nome = entrada.next();
		estado.setNome(nome);
		teste.setNome(nome);
		
		System.out.println("Sigla: ");
		String sigla = entrada.next();
		estado.setSigla(sigla);
		teste.setSigla(sigla);
		
			new DaoEstado().salvar(estado);
			new DaoEstado().salvar(teste);
		
		// persist salva
		// merge altera
		// remove apaga
		// find busca
	}
}
