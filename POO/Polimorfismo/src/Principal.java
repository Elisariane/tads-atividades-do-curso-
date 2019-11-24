
public class Principal {

	public static void main(String[] args) {
		Forma circulo = new Circulo(5.5, "Blue", false); 
		System.out.println("Círculo");                                
		System.out.println("Cor: "+circulo.getCor());
		System.out.println("A forma está preenchida? "+circulo.isPreenchida());
		System.out.println("Área: "+circulo.getArea());
		System.out.println("Perimêtro: "+ circulo.getPerimetro());
		
		System.out.println("-------------------------------------");

		Forma retangulo = new Retangulo(5.0, 8.0, "Green", false);   
		System.out.println("Retangulo");
		System.out.println("Cor: "+retangulo.getCor());
		System.out.println("Perimêtro: "+"A forma está preenchida? "+retangulo.isPreenchida());
		System.out.println(retangulo.getPerimetro());
		System.out.println("Área: "+retangulo.getArea());
		   
	
	
		
		
	}
	
	
	
}
