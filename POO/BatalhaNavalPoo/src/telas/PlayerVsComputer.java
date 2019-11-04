package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

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

		
		int contDisparo = 0;
		if(contDisparo >= 10) {
			
			int contDestruidos = 0;
			if(contDestruidos == 0) {
				
			JOptionPane.showMessageDialog(null, "10 disparos e não acertou um! Cê é ruim");
			
			}
			else {
				
			JOptionPane.showMessageDialog(null, "10 disparos e "+contDestruidos+" alvos destruídos! \nMUITO BOM");
				
				
			}
			
		}
		else {
			contDisparo++;
		}
		
	}
	

}