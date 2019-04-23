package Fabrica;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaAulaPersistencia {
	//responsavel pelo mapeamento OR
	//pesado, recomendado criar somente um
	private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("aulaPersistencia");
	
	public static EntityManagerFactory getFabrica(){
		return fabrica;
	}
}
