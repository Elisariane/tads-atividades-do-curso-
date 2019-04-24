package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import Fabrica.FabricaAulaPersistencia;
import entidade.Cidade;

public class DaoCidade {

	EntityManagerFactory fabrica;

	public DaoCidade() {
		fabrica = FabricaAulaPersistencia.getFabrica();
	}

	
	public Cidade salvar(Cidade cidade) {
		EntityManager gerenciador = fabrica.createEntityManager();
		EntityTransaction transacao = gerenciador.getTransaction();

		transacao.begin();
		gerenciador.persist(cidade);
		transacao.commit();
		return cidade;
	}
	
	public Cidade altera(Cidade cidade) {
		EntityManager gerenciador = fabrica.createEntityManager();
		EntityTransaction transacao = gerenciador.getTransaction();

		transacao.begin();
		gerenciador.merge(cidade);
		transacao.commit();
		return cidade;
	}
	
	public boolean delete(Cidade cidade) {
		EntityManager gerenciador = fabrica.createEntityManager();
		EntityTransaction transacao = gerenciador.getTransaction();

		transacao.begin();
		gerenciador.remove(cidade);
		transacao.commit();
		
		return true;
	}
	
	public List<Cidade> consultar() {
		EntityManager gerenciador = fabrica.createEntityManager();
		
		return gerenciador.createQuery("Select c FROM Cidade c", Cidade.class).getResultList();
		
	
		
	}
	
}
