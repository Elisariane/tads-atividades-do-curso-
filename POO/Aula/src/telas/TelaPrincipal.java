package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame implements ActionListener {
	// Criando um desktop
	private JDesktopPane desk = new JDesktopPane();
	private TelaJogoDaVelha tjv;
	private TelaJogoDaForca telaForca;

	// Criando um objeto para ser o menu bar
	private JMenuBar jmb = new JMenuBar();

	// Criando Menu
	private JMenu jogos = new JMenu("Jogos");
	private JMenu utilitarios = new JMenu("Utilitários");
	private JMenu ajuda = new JMenu("Ajuda");

	// Criando Menu itens para jogos
	private JMenuItem jogoDaVelha = new JMenuItem("Jogo da Velha");
	private JMenuItem forca = new JMenuItem("Jogo da Forca");

	// Criando menu itens para utilitarios
	private JMenuItem calculadora = new JMenuItem("Calculadora");

	// Criando menu itens para ajuda
	private JMenuItem informacoes = new JMenuItem("Informações");

	// Construtor com definições
	public TelaPrincipal() {
		setTitle("Projeto Aula POO");
		setSize(1024, 768);
		definirMenu();
		setVisible(true);
		setLocationRelativeTo(null);

	}

	private void definirMenu() {

		setJMenuBar(jmb);
		// Add o menu jogos
		jmb.add(jogos);
		// Add o menu item de jogos
		jogos.add(jogoDaVelha);
		// Add o menu item de jogos
		jogos.add(forca);
		// Add o menu utilitarios
		jmb.add(utilitarios);
		// Add o menu item utilitarios
		utilitarios.add(calculadora);
		// Add o menu ajuda
		jmb.add(ajuda);
		// Add o menu item ajuda
		ajuda.add(informacoes);

		// Colocar na tela jogo da velha a action
		jogoDaVelha.addActionListener(this);
		forca.addActionListener(this);
		informacoes.addActionListener(this);
		calculadora.addActionListener(this);

		// Add o desk
		add(desk);

		setVisible(true);

		

	}

	public static void main(String[] args) {

		TelaPrincipal p = new TelaPrincipal();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jogoDaVelha) {
			if(tjv == null) {
				tjv = TelaJogoDaVelha.criarTela();
				desk.add(tjv);
			}
			 

		}

		else if (e.getSource() == telaForca) {
			if(tjv == null) {
				telaForca = TelaJogoDaForca.criarTela();
				desk.add(forca);
			}

		}

		else if (e.getSource() == informacoes) {
			
			TelaAjuda info = new TelaAjuda();
			desk.add(info);
		}
		
		else if (e.getSource() == calculadora) {
			TelaCalculadora calculadora = new TelaCalculadora();
			desk.add(calculadora);
		}
	}

}
