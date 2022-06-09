package br.com.fiap.gs.apmd.posto.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.gs.apmd.posto.model.Posto;

public class PostoDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("posto");
	EntityManager manager = factory.createEntityManager();
	
	public void inserir(Posto posto) {
		manager.getTransaction().begin();
		manager.persist(posto);
		manager.getTransaction().commit();
	}
	
	public List<Posto> listarTodos(){
		String jpql = "SELECT p FROM Posto p";
		TypedQuery<Posto> query = manager.createQuery(jpql , Posto.class);
		return query.getResultList();
	}
	
	public void apagar(Posto posto) {
		manager.getTransaction().begin();
		manager.remove(manager.merge(posto));
		manager.getTransaction().commit();
	}
	
	public void atualizar(Posto posto) {
		manager.getTransaction().begin();
		manager.merge(posto);
		manager.getTransaction().commit();
	}

}
