package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sun.tools.javac.util.List;

import ec.edu.ups.pojos.TarjetaDeCredito;

@Stateless
public class TarjetaDeCreditoFacade extends AbstractFacade<TarjetaDeCredito>{
	
	@PersistenceContext(unitName = "Examen")
	private EntityManager em;

	public TarjetaDeCreditoFacade() {
	super(TarjetaDeCredito.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	
	public List<TarjetaDeCredito> ListaTarjetas(int id){
		String jpql = "SELECT tar FROM TarjetaDeCredito tar where tar.numTarjeta="+id;
	List<TarjetaDeCredito> tarjetaDeCredito = (List<TarjetaDeCredito>) em.createQuery(jpql).getResultList();
	return tarjetaDeCredito;
	}
}
