package telas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import tabuleiro.Tabuleiro;

public class PlayerVsPlayer extends JInternalFrame implements ActionListener {

	private static PlayerVsPlayer tela;

	private Tabuleiro tabuleiroPlayerUm;
	private Tabuleiro tabuleiroPlayerDois;
	private JLabel placar;
	private JFrame f;
	JPanel panel = new JPanel();

	public PlayerVsPlayer() {
		super("Batalha Naval", true, true, true);
		GridLayout layout = new GridLayout(3, 2);
		setLayout(layout);
		tabuleiroPlayerUm = new Tabuleiro();
		tabuleiroPlayerDois = new Tabuleiro();
		add(tabuleiroPlayerUm).setSize(200, 200);
		add(tabuleiroPlayerDois).setSize(200, 200);
		
		setSize(1600, 1080);

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
