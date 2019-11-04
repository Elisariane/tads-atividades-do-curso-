package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import tabuleiro.Tabuleiro;

public class PlayerVsPlayer  extends JInternalFrame implements ActionListener {
	
	private static PlayerVsPlayer tela;

	private Tabuleiro tabuleiroPlayerUm;
	private Tabuleiro tabuleiroPlayerDois;
	
	
	public PlayerVsPlayer() {
		super("Batalha Naval", true, true, true);
		tabuleiroPlayerUm = new Tabuleiro();
		tabuleiroPlayerDois = new Tabuleiro();
		add(tabuleiroPlayerUm);
		add(tabuleiroPlayerDois);
		setSize(20, 20);
		
		setVisible(true);

	}
	
	
	public static PlayerVsPlayer criarTela() {
		if (tela == null) {
			tela = new PlayerVsPlayer();

		}

		return tela;
	}
	
	
	public void actionPerformed(ActionEvent e) {

	}

}
