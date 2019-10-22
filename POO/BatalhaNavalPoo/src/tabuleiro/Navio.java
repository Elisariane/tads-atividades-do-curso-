package tabuleiro;

public class Navio {

	private String nome;
	private int tamanho;
	private int[] coordenadaInicial;
	private int[] coordenadaFinal;

	public Navio() {
		this.tamanho = 1;
		this.nome = "Submarino";
		
//		if(tam == 1) {
//			this.nome = "Submarino";
//			
//		}
//		if(tam == 2) {
//			this.nome = "Destroyer";
//			
//		}
//		if(tam == 3) {
//			this.nome = "Cruzador";
//			
//		}
//		if(tam == 4) {
//			this.nome = "Porta-avião";
//			
//		}
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public int[] getCoordenadaInicial() {
		return coordenadaInicial;
	}
	public void setCoordenadaInicial(int[] coordenadaInicial) {
		this.coordenadaInicial = coordenadaInicial;
	}
	public int[] getCoordenadaFinal() {
		return coordenadaFinal;
	}
	public void setCoordenadaFinal(int[] coordenadaFinal) {
		this.coordenadaFinal = coordenadaFinal;
	}

	
}
