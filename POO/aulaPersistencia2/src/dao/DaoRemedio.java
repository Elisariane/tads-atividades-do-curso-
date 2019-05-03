package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Fabrica.FabricaAulaPersistencia;
import entidade.Remedio;

public class DaoRemedio {
	private EntityManager em;

	public Remedio salvar(Remedio remedio) {
		em = FabricaAulaPersistencia.getFabrica().createEntityManager();
		EntityTransaction transacao = em.getTransaction();
		try {
			transacao.begin();
			em.persist(remedio);
			transacao.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return remedio;
	}

	public Remedio altera(Remedio remedio) {
		em = FabricaAulaPersistencia.getFabrica().createEntityManager();
		EntityTransaction transacao = em.getTransaction();

		try {
			transacao.begin();
			em.merge(remedio);
			transacao.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return remedio;

	}

	public boolean delete(Remedio remedio) {
		em = FabricaAulaPersistencia.getFabrica().createEntityManager();
		EntityTransaction transacao = em.getTransaction();

		try {
			transacao.begin();
			em.remove(remedio);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return true;
	}

	public List<Remedio> consultar() {
		em = FabricaAulaPersistencia.getFabrica().createEntityManager();

		return em.createQuery("FROM remedio", Remedio.class).getResultList();

	}

}
