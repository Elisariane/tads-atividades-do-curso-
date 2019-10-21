package telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

public class PlayerVsComputer extends JInternalFrame implements ActionListener {

	List<JButton> tabuleiro = new ArrayList<JButton>();

	private GridLayout layout = new GridLayout(9, 9);

	private static PlayerVsComputer tela;

	public PlayerVsComputer() {
		super("Batalha Naval", true, true, true);
		setLayout(layout);
		setSize(400, 300);
		setVisible(true);
		JButton botao;

		for (int i = 0; i < 9; i++) {
			botao = new JButton();

			tabuleiro.add(botao);
			botao.setSize(50, 50);
			botao.addActionListener(this);
			add(botao);

		}
		
		

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
