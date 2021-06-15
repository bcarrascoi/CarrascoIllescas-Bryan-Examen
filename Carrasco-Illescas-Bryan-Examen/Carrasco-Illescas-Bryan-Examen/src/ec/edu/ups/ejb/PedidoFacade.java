package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pojos.Pedido;

@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

	@PersistenceContext(unitName = "Carrasco-Illescas-Bryan-Examen")
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

	@SuppressWarnings("unchecked")
	public List<Pedido> encontrarPedidos(int codigo) {
		String jdbc = "select p from Product p where p.almacen.codigo=" + codigo;
		return (List<Pedido>) em.createQuery(jdbc).getResultList();
	}

	public List<Pedido> buscarNumTarjeta(String numero) {
		String jpql = "select pe from Pedido pe inner join pe.tarjetaDeCredito tar WHERE tar.numeroTarjeta= '" + numero + "'";
		return em.createQuery(jpql, Pedido.class).getResultList();
	}

	public List<Pedido> buscarNombreComida(String nombre) {
		String jpql = "select ped from Pedido ped inner join ped.comidas tar WHERE tar.nombre= '" + nombre + "'";
		return em.createQuery(jpql, Pedido.class).getResultList();
	}

}
