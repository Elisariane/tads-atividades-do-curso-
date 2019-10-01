package telas;

import javax.swing.JInternalFrame;

public class TelaJogoDaForca extends JInternalFrame{
	
	private static TelaJogoDaForca tela;

	public TelaJogoDaForca() {
		super("Jogo da Forca", true, true, true);
		setSize(400, 300);
		setVisible(true);
		
	
		
		
	}
	
	
	public static TelaJogoDaForca criarTela() {
		if (tela == null)

		{
			tela = new TelaJogoDaForca();

		} return tela;

	}

}
