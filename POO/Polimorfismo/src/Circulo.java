
public class Circulo extends Forma {

	//Atributo
	protected double raio;
	
	
	// Getter�s e Setter�s
	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}
	// Getter�s e Setter�s fim //
	
	
	
	//Construtor 
	public Circulo(double raio, String cor, boolean preenchida) {
		super(cor, preenchida);
		this.raio = raio;
	}

	@Override
	public double getArea() {
		double area = (3.14* ( Math.pow(getRaio(),2)));
		return area;
	}

	@Override
	public double getPerimetro() {

		double perimetro = (3.14* (2*getRaio()));

		return perimetro;
	}

}
