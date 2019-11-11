package tabuleiro;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import barulinhos.Sound;

public class Tabuleiro extends JPanel implements ActionListener {
	List<JButton> tabuleiro = new ArrayList<JButton>();

	List<Navio> navios = new ArrayList<Navio>();
	private GridLayout layout = new GridLayout(9, 9);

	int contDisparo = 0;
	int contDestruidos = 0;
	boolean vitoria;

	private static Tabuleiro tela;

	public Tabuleiro() {

		setLayout(layout);
		setSize(800, 800);
		setVisible(true);
		JButton botao;

		for (int i = 0; i < 10; i++) {
			Navio navio = new Navio();
			int[] coo = getCoordenadas();
			while (this.validaDisparo(coo[0], coo[1])) {
				coo = getCoordenadas();
			}
			navio.setCoordenadaInicial(coo);
			navio.setCoordenadaFinal(coo);

			navios.add(navio);
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				botao = new JButton(new ImageIcon("src\\images\\water.jpg"));
				tabuleiro.add(botao);
				botao.setSize(88, 88);
				botao.setText("" + j + ":" + i);
				botao.addActionListener(this);
				add(botao);
			}
		}

	}

	public static int[] getCoordenadas() {
		Random r = new Random();
		int x = r.nextInt(8);
		int y = r.nextInt(8);
		int[] coo = { x, y };
		return coo;
	}

	public static Tabuleiro criarTela() {
		if (tela == null) {
			tela = new Tabuleiro();

		}

		return tela;
	}

	private boolean validaDisparo(int x, int y) {
		for (Navio navio : navios) {
			int[] coord = navio.getCoordenadaInicial();
			if (coord[0] == x && coord[1] == y) {
				return true;
			}
		}

		return false;
	}

	private int score() {
		if (contDisparo >= 10) {

			if (contDestruidos == 0) {

				JOptionPane.showMessageDialog(null, "10 disparos e não acertou um! Cê é ruim");

			} else {

				JOptionPane.showMessageDialog(null,
						"10 disparos e " + contDestruidos + " alvos destruídos! \nMUITO BOM");

			}

		} else {
			contDisparo++;
		}

		return contDestruidos;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();
		int x = 0, y = 0;
		int a = 0;
		for (String comp : botao.getText().split(":")) {
			if (a == 0) {
				x = Integer.parseInt(comp);
				a++;
			} else {
				y = Integer.parseInt(comp);
			}
		}
		if (this.validaDisparo(x, y)) {
			botao.setIcon(new ImageIcon("src\\images\\sub.png"));
			Sound.play("src\\barulinhos\\acertou.wav");
			contDestruidos++;
		} else {
			botao.setIcon(new ImageIcon("src\\images\\bomb.PNG"));
			Sound.play("src\\barulinhos\\errou.wav");
		}
		score();
	}

}
