package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sun.tools.javac.util.List;

import ec.edu.ups.pojos.Pedido;

@Stateless
public class PedidoFacade extends AbstractFacade<Pedido>{

	@PersistenceContext(unitName = "Examen")
	private EntityManager em;
	
	public PedidoFacade() {
	super(Pedido.class);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	
	public Pedido buscar(int idPed, int idTar){
		try {
		String jqpl = "SELECT ped FROM Pedido ped where ped.numPedido=" + idPed +"AND ped.tarjeta_id="+idTar;
	Pedido pedidotar = (Pedido) em.createQuery(jqpl).getSingleResult();
	return pedidotar;
	
	}catch(Exception e) {
		e.printStackTrace();
		return null;
	}
	
	}
}
