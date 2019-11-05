package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Principal extends JFrame implements ActionListener {

			public Principal() {
		setTitle("Projeto Java POO");
		setSize(1024, 768);
		definirMenu();
		setVisible(true);
		setLocationRelativeTo(null);
	
	}

	
	// Criando um desktop
	private JDesktopPane desk = new JDesktopPane();

	// Variaveis para as telas
	private PlayerVsPlayer telaJogadorXJogador;
	private PlayerVsComputer telaJogadorXComputador;

	// Criar a barra do menu
	private JMenuBar jmb = new JMenuBar();

	// Criar o menu
	private JMenu jogo = new JMenu("Batalha Naval");
	private JMenu ajuda = new JMenu("Ajuda");
	//private JMenu conversores = new JMenu("Conversores");

	// Criando o item para cada opção do menu
	private JMenuItem modoJogador = new JMenuItem("Modo Player versus Player");
	private JMenuItem modoComputador = new JMenuItem("Modo Player versus Computador");

	private JMenuItem regra = new JMenuItem("Regras - Batalha Naval");




	private void definirMenu() {
		setJMenuBar(jmb);
		// Add o menu do jogo batalha naval
		jmb.add(jogo);
		// Add item do menu de jogo
		jogo.add(modoComputador);
		jogo.add(modoJogador);
		// Add o menu ajuda
		jmb.add(ajuda);
		// Add item do menu ajuda
		ajuda.add(regra);

		// Action
		modoJogador.addActionListener(this);
		modoComputador.addActionListener(this);
		
		// Add no Desktop
		add(desk);

		setVisible(true);

	}

public static void main(String[] args) {
	Principal p = new Principal();
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == modoComputador) {
			if (telaJogadorXComputador == null) {
				telaJogadorXComputador = PlayerVsComputer.criarTela();
				desk.add(telaJogadorXComputador);
			}

		}
		
		else if (e.getSource() == modoJogador) {
			if(telaJogadorXJogador == null) {
				telaJogadorXJogador = PlayerVsPlayer.criarTela();
				desk.add(telaJogadorXJogador);
			}
		}

		
	}

}
