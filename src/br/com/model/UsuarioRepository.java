package br.com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UsuarioRepository {
	private List<Usuario> usuarios = lista();
	
	public Usuario buscaId(Long id) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("strutsDb");
		EntityManager em = factory.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, id); //(Classe, ID)
		
		return usuario;
		//return UsuarioRepository.usuarios.get((int) (id - 1));
		
		
	}
	
	public void adiciona(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("strutsDb");
		EntityManager em = factory.createEntityManager();
		//usuario.setId((long) (UsuarioRepository.usuarios.size() + 1));
		//UsuarioRepository.usuarios.add(usuario);
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	public void remove(Long id) {
		//UsuarioRepository.usuarios.remove((long) id - 1);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("strutsDb");
		EntityManager em = factory.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, id); //(Classe, ID)
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	public void altera(Usuario usuario) {
		//UsuarioRepository.usuarios.set((int) (usuario.getId() - 1), usuario);
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("strutsDb");
		EntityManager em = factory.createEntityManager();
		Usuario updatedUser = em.find(Usuario.class, usuario.getId());
		
		em.getTransaction().begin();
		/*p.setName("Kevin McHale");
		p.setNumber(32);
		p.setTeam("Boston Celtics");
		usuario.*/
		updatedUser.setName(usuario.getName());
		updatedUser.setPassword(usuario.getPassword());
		updatedUser.setUsername(usuario.getUsername());
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Usuario> lista() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("strutsDb");
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
	    CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
	    Root<Usuario> root = query.from(Usuario.class);
	    query.select(root);

	    List<Usuario> ListPlayers = em.createQuery(query).getResultList();
	    
	    //return new ArrayList<Usuario>(UsuarioRepository.usuarios);
	    return ListPlayers;
	}
}
