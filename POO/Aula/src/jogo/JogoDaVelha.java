package jogo;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JogoDaVelha extends JFrame {
	
private GridLayout layout = new GridLayout(3,3);
	
	private JButton bt1 = new JButton("");
	private JButton bt2 = new JButton("");
	private JButton bt3 = new JButton("");
	private JButton bt4 = new JButton("");
	private JButton bt5 = new JButton("");
	private JButton bt6 = new JButton("");
	private JButton bt7 = new JButton("");
	private JButton bt8 = new JButton("");
	private JButton bt9 = new JButton("");
	
	public JogoDaVelha() {

		super("Jogo da Velha");
		setLayout(layout);
		
		add(bt1).setSize(50,50);
		add(bt2).setSize(50,50);
		add(bt3).setSize(50,50);
		add(bt4).setSize(50,50);
		add(bt5).setSize(50,50);
		add(bt6).setSize(50,50);
		add(bt7).setSize(50,50);
		add(bt8).setSize(50,50);
		add(bt9).setSize(50,50);
		setSize(400, 300);
		setVisible(true);
		
	}
	
	

	  

}
