
abstract class Forma {
	
//	Classes abstratas
//
//	Pode-se dizer que as classes abstratas servem como �modelo� para outras classes que dela herdem, n�o
//	podendo ser instanciada por si s�. Para ter um objeto de uma classe abstrata � necess�rio criar uma
//	classe mais especializada herdando dela e ent�o instanciar essa nova classe. Os m�todos da classe
//	abstrata devem ent�o serem sobrescritos nas classes filhas.
	
	
	//Atributos
	protected String cor;
	protected boolean preenchida;
	
	//Construtor
	public Forma(String cor, boolean preenchida) {
		this.cor = cor;
		this.preenchida = preenchida;
		
		
	}

	// Getter�s e Setter�s
	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public boolean isPreenchida() {
		return preenchida;
	}


	public void setPreenchida(boolean preenchida) {
		this.preenchida = preenchida;
	}
	
	// Getter�s e Setter�s fim //
	
	// M�todos
	public abstract double getArea();
	
	public abstract double getPerimetro();
	
}
