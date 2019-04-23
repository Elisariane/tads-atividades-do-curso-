package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.HibernateException;

import Fabrica.FabricaAulaPersistencia;
import entidade.Estado;

public class DaoEstado {
	EntityManagerFactory fabrica;

	public DaoEstado() {
		fabrica = FabricaAulaPersistencia.getFabrica();
	}

	Estado estado = new Estado();

	public boolean salvar(Estado estado) {
		try{
		// gerenciador ... criar um para cada dao
		// representa a conexão e tem metodos CRUD
		EntityManager gerenciador = fabrica.createEntityManager();
		// gerencia a transação dos dados
		EntityTransaction transacao = gerenciador.getTransaction();

		transacao.begin();
		gerenciador.persist(estado);
		transacao.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	public boolean alterar(Estado estado) {
		try {
			// gerenciador ... criar um para cada dao
			// representa a conexão e tem metodos CRUD
			EntityManager gerenciador = fabrica.createEntityManager();
			// gerencia a transação dos dados
			EntityTransaction transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(estado);
			transacao.commit();
			
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(Estado estado) {
		
		try{// gerenciador ... criar um para cada dao
		// representa a conexão e tem metodos CRUD
		EntityManager gerenciador = fabrica.createEntityManager();
		// gerencia a transação dos dados
		EntityTransaction transacao = gerenciador.getTransaction();
		
		transacao.begin();
		gerenciador.remove(estado);
		transacao.commit();
		
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List<Estado> consultar() {
		try{// gerenciador ... criar um para cada dao
			// representa a conexão e tem metodos CRUD
			EntityManager gerenciador = fabrica.createEntityManager();
			// gerencia a transação dos dados
			EntityTransaction transacao = gerenciador.getTransaction();
			
			transacao.begin();
			List<Estado> lista = gerenciador.createQuery("SELECT * FROM estado ", Estado.class).getResultList();
			transacao.commit();
			return lista;
			
			}catch(HibernateException e) {
				e.printStackTrace();
				return null;
			}
	}
}
