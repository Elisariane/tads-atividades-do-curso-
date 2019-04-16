package principal;

import java.util.Scanner;

import tela.TelaCidade;
import tela.TelaEstado;

public class Principal {
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("1-Estado");
		System.out.println("2-Cidade");
		System.out.println("3-Sair");
		int op = scan.nextInt();
		scan.nextLine();
		
		if(op ==1) {
			TelaEstado t = new TelaEstado();
		}
		else if(op == 2) {
			TelaCidade telacid = new TelaCidade();
		}else {
		
			System.out.println("Saindo...");
		
		}
		
		
	}

}
