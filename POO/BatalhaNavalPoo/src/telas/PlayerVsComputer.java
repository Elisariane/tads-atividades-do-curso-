package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

import tabuleiro.Tabuleiro;

public class PlayerVsComputer extends JInternalFrame implements ActionListener {

	private static PlayerVsComputer tela;
	private Tabuleiro tabuleiro;

	public PlayerVsComputer() {
		super("Batalha Naval", true, true, true);
		tabuleiro = new Tabuleiro();
		add(tabuleiro);
		setSize(680, 450);
		setVisible(true);
	}

	public static PlayerVsComputer criarTela() {
		if (tela == null) {
			tela = new PlayerVsComputer();

		}

		return tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
