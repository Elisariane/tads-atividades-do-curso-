package tela;

import java.util.ArrayList;
import java.util.Scanner;

import dao.DAOEstado;
import dao.DaoCidade;
import entidade.Cidade;
import entidade.Estado;

public class TelaCidade {
	String r = "s";
	int op = 0;

	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - salvar \n 2 - excluir \n 3 - alterar \n 4 - consultar \n";
	DaoCidade daoc = new DaoCidade();
	Cidade cidade = new Cidade();
	Estado estado = new Estado();

	public TelaCidade() {
		do {
			System.out.println(menu);
			op = scan.nextInt();
			scan.nextLine();

			if (op == 1) {
				System.out.println("nome:");
				String nome = scan.nextLine();

				DAOEstado daoe = new DAOEstado();
				ArrayList<Estado> estados = daoe.consultar();

			for (int i = 0; i < estados.size(); i++) {
				System.out.println(
							"Id: " + estados.get(i).getId() + 
							" Nome: " + estados.get(i).getNome() + 
							" Sigla: " + estados.get(i).getSigla());
			}
								
				System.out.println("Insira o id do estado desejado: ");
				int idest = scan.nextInt();

				for (Estado est : estados) {
					if (est.getId() == idest) {
						estado = est;
						break;
					}
				}

				// estado.setId(idest);
				// estado = estados.get(estados.indexOf(estado));

				cidade.setNome(nome);
				cidade.setEstado(estado);

				daoc.salvar(cidade);

			}

			if (op == 2) {
				System.out.println("Consultar...");

				daoc.consultar();

			}

			if (op == 3) {
				System.out.println("Deletar dado...");

				System.out.print("Digite o id a ser apagado: \n");
				int id = scan.nextInt();
				cidade.setID(id);

				// daoe.excluir(estado);

			}

			if (op == 4) {
				System.out.println("Alterar dado...");

				System.out.print("Altere o nome da cidade : \n");
				String nome = scan.next();
				cidade.setNome(nome);

				System.out.print("Digite o id da cidade a ser alterado: \n");
				int id = scan.nextInt();
				cidade.setID(id);

			}
		} while (op < 1 && op > 4);

	}

}
