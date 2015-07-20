package br.com.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CarroRepository {
	
	private EntityManager manager;
	
	public CarroRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public void adiciona(Carro carro) {
		this.manager.persist(carro);
	}
	
	@SuppressWarnings("unchecked")
	public List<Carro> buscaTodos() {
		//FEITO COM QUERY//
		Query query = this.manager.createQuery("select x from Carro x");
		return query.getResultList();
		//FEITO COM QUERY//
		
		//FEITO COM CRITERIA//
		/*CriteriaBuilder builder = manager.getCriteriaBuilder();
	    CriteriaQuery<Carro> query = builder.createQuery(Carro.class);
	    Root<Carro> root = query.from(Carro.class);
	    query.select(root);
	    List<Carro> ListPlayers = manager.createQuery(query).getResultList();
	    return ListPlayers;*/
	    //FEITO COM CRITERIA//
	}
}
