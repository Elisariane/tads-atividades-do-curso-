
public class Principal {

	public static void main(String[] args) {
		Forma circulo = new Circulo(5.5, "Blue", false); 
		System.out.println("C�rculo");                                
		System.out.println("Cor: "+circulo.getCor());
		System.out.println("A forma est� preenchida? "+circulo.isPreenchida());
		System.out.println("�rea: "+circulo.getArea());
		System.out.println("Perim�tro: "+ circulo.getPerimetro());
		
		System.out.println("-------------------------------------");

		Forma retangulo = new Retangulo(5.0, 8.0, "Green", false);   
		System.out.println("Retangulo");
		System.out.println("Cor: "+retangulo.getCor());
		System.out.println("Perim�tro: "+"A forma est� preenchida? "+retangulo.isPreenchida());
		System.out.println(retangulo.getPerimetro());
		System.out.println("�rea: "+retangulo.getArea());
		   
	
	
		
		
	}
	
	
	
}
