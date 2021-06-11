package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pojos.Comidas;

@Stateless
public class ComidaFacade extends AbstractFacade<Comidas>{

	@PersistenceContext(unitName = "Examen")
	private EntityManager em;
	
	public ComidaFacade() {
		super(Comidas.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Comidas buscarCom(String nombre) {
		try {
			String jpql = "SELECT com FROM Comidas com Where com.nombre='"+nombre+"'";
			Comidas com = (Comidas) em.createQuery(jpql).getSingleResult();
		return com;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
