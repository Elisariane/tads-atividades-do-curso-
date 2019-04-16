package tela;

import java.util.Scanner;

import dao.DAOEstado;
import entidade.Estado;

public class TelaEstado {

	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - salvar \n 2 - excluir \n 3 - alterar \n 4 - consultar \n";
	private Estado estado = new Estado();
	private DAOEstado daoe = new DAOEstado();

	public TelaEstado() {
		String r = "s";
		int op = 0;

		do {
			System.out.println(menu);
			op = scan.nextInt();
			scan.nextLine();

			if (op == 1) {
				System.out.println("nome:");
				String nome = scan.nextLine();

				System.out.println("sigla:");
				String sigla = scan.nextLine();

				estado.setNome(nome);
				estado.setSigla(sigla);

				daoe.salvar(estado);
			}

			if (op == 2) {
				System.out.println("Consultar...");

				daoe.consultar();

			}

			if (op == 3) {
				System.out.println("Deletar dado...");

				System.out.print("Digite o id a ser apagado: \n");
				int idest = scan.nextInt();
				estado.setId(idest);

				daoe.excluir(estado);

			}

			if (op == 4) {
				System.out.println("Alterar dado...");

				System.out.print("Altere o nome do estado : \n");
				String nome = scan.next();
				estado.setNome(nome);

				System.out.print("Digite o id do estado a ser alterado: \n");
				int idest = scan.nextInt();
				estado.setId(idest);

				daoe.alterar(estado);
				System.out.println("Continuar? (s/n)");
				r = scan.nextLine();
			}
		} while (op < 1 && op > 4);

	}
}
