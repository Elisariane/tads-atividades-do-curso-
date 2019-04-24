package Fabrica;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaAulaPersistencia {
	//responsavel pelo mapeamento OR
	//pesado, recomendado criar somente um
	private static EntityManagerFactory fabrica;
	
	
	public static EntityManagerFactory getFabrica(){
		if(fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("aulaPersistencia");
		}
		return fabrica;
	}
}
