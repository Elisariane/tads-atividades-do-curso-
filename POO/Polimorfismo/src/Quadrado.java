
public class Quadrado extends Forma{

	//Atributo
	protected double lado;
	
	// Getter�s e Setter�s
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	// Getter�s e Setter�s fim //
	
	public Quadrado(double lado, String cor, boolean preenchida) {
		super(cor, preenchida);
		this.lado =lado;
	}

	
	@Override
	public double getArea() {
		double area = getLado() *getLado();
		
		return area;
		
	}

	@Override
	public double getPerimetro() {
		double perimetro = getLado()+getLado()+getLado()+getLado();
		return perimetro;
	}

}
