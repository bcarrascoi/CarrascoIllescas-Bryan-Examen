package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pojos.Tarjeta;

@Stateless
public class TarjetaDeCreditoFacade extends AbstractFacade<Tarjeta>{
	
	@PersistenceContext(unitName = "Carrasco-Illescas-Bryan-Examen")
	private EntityManager em;

	public TarjetaDeCreditoFacade() {
	super(Tarjeta.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
		
	public Tarjeta buscarTarjeta(int numTarjeta) {
		try {
			String jpql = "SELECT tar FROM TarjetaDeCredito tar WHERE tar.numTarjeta='" + numTarjeta + "'";
			Tarjeta tar = (Tarjeta)em.createQuery(jpql).getSingleResult();
			return tar;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}		
}
