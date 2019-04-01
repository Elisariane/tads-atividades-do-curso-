package principal;

import java.sql.Connection;
import java.util.Scanner;

import conexao.Conexao;
import dao.DaoEstado;
import entidade.Estado;

public class Principal {

	public static void main(String[] args) {
		System.out
				.println("-- Tabela Estado--\n"
						+ "1- Inserir\n2- Consultar\n3- Deletar\n4- Alterar\n0- Sair\n--		 --");
		System.out.println("Opções: ");
		Scanner entrada = new Scanner(System.in);

		DaoEstado dao = new DaoEstado();
		Estado estado = new Estado();

		boolean sair = false;

		do {
			int opcao = entrada.nextInt();

			if (opcao == 1) {
				System.out.println("Inserir estado...");

				System.out.print("Digite o nome do estado: \n");
				String nome = entrada.next();
				estado.setNome(nome);

				System.out.print("Digite a sigla do estado: ");
				String sigla = entrada.next();
				estado.setSigla(sigla);
				dao.salvar(estado);

			}

			if (opcao == 2) {
				System.out.println("Consultar...");

				dao.consultar(estado);

			}

			if (opcao == 3) {
				System.out.println("Deletar dado...");

				System.out.print("Digite o id a ser apagado: \n");
				int idest = entrada.nextInt();
				estado.setIdest(idest);

				dao.excluir(estado);

			}

			if (opcao == 4) {
				System.out.println("Alterar dado...");

				System.out.print("Altere o nome do estado : \n");
				String nome = entrada.next();
				estado.setNome(nome);

				System.out.print("Digite o id do estado a ser alterado: \n");
				int idest = entrada.nextInt();
				estado.setIdest(idest);

				dao.alterar(estado);

			} else {
				System.out.println("Encerrando...\n");
				sair = true;
			}

		} while (sair == false);

	}

}