
public class Retangulo extends Forma {

	//Atributo
		protected double largura;
		protected double altura;
		
		// Getter큦 e Setter큦
		public double getLargura() {
			return largura;
		}

		public void setLargura(double largura) {
			this.largura = largura;
		}

		public double getAltura() {
			return altura;
		}

		public void setAltura(double altura) {
			this.altura = altura;
		}
		// Getter큦 e Setter큦 fim //
		
		
		
		//Construtor 
	public Retangulo(double largura, double altura, String cor, boolean preenchida) {
		super(cor, preenchida);
		this.altura = altura;
		this.largura = largura;
	}



	@Override
	public double getArea() {
		double area = getAltura()*getLargura();
		return area;
	}

	@Override
	public double getPerimetro() {
		double perimetro = getAltura()+getAltura()+getLargura()+getLargura();
		return perimetro;
	}

}
