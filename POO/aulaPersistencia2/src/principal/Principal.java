package principal;

import java.util.Scanner;

import telas.TelaCidade;
import telas.TelaEstado;

public class Principal {

	private static Scanner entrada;
	private static TelaEstado estado;
	private static TelaCidade cidade;

	public static void main(String[] args) {
		
		entrada = new Scanner(System.in);

		
		System.out.println("----Tabelas----\n1- Estado\n2- Cidade");
		
		int op =0;
		System.out.println("Opção: ");
		op = entrada.nextInt();
		if(op == 1 ) {
			estado = new TelaEstado();
		}
		
		
		else if(op == 2) {
			
			cidade = new TelaCidade();			
			
		}else {
			System.out.println("Saindo...");
		}
		
	}
	
	
}
