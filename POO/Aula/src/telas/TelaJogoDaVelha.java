package telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

public class TelaJogoDaVelha extends JInternalFrame implements ActionListener {
    
	List<JButton> botoes = new ArrayList<JButton>();
	private String valorAtual = "X";
	
	private static TelaJogoDaVelha tela;
	
	
	private GridLayout layout = new GridLayout(3,3);
	
	
	public TelaJogoDaVelha() {

		super("Jogo da Velha", true, true, true, true);
		setLayout(layout);
		setLayout(layout);
		JButton botao;
		for(int i=0; i<9;i++) {
			
			botao = new JButton();
			botoes.add(botao);
			botao.setSize(50,50);
			botao.addActionListener(this);
			add(botao);
		}
		
		setSize(400, 300);
		setVisible(true);
		
	}

	public static TelaJogoDaVelha criarTela() {
		if (tela == null)

		{
			tela = new TelaJogoDaVelha();

		}
		return tela;

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botaoClicado = (JButton) e.getSource();
		if(valorAtual == "X") {
			valorAtual = "0";
		}else {
			valorAtual = "X";
		}
		botaoClicado.setText(valorAtual);

	}
	

}