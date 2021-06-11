package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pojos.Empleados;

@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleados>{
	
	@PersistenceContext(unitName = "Prueba")
    private EntityManager em;
	
	public EmpleadoFacade() {
		super(Empleados.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Empleados buscarEmp (String email, String password) {
		try {
			String jpql = "SELECT emp FROM Empleados emp WHERE emp.email='" + email + "'"+"  AND  emp.password='"+password+"'";
			Empleados emp = (Empleados) em.createQuery(jpql).getSingleResult();
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Empleados finByEmailAndPass(String email, String password) {
        try {
            String jpql = "FROM Empleados emp WHERE emp.email =  ?1 AND emp.password = ?2";
            Query query = em.createQuery(jpql);
            query.setParameter(1, email);
            query.setParameter(2, password);
            return (Empleados) query.getSingleResult();
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return null;
        }

    }
	
	 public List<Empleados> findClientes() {
	        String jpql = "FROM Empleados emp WHERE emp.rol = 'cliente' ORDER BY emp.nombre DESC";
	        return (List<Empleados>) em.createQuery(jpql).getResultList();
	    }
	    
	    public List<Empleados> findByCedula(String cedula) {
	        String jpql = "FROM Empleados emp WHERE emp.cedula = '"+cedula+"' AND emp.rol = 'cliente' ORDER BY emp.nombre DESC";
	        return (List<Empleados>) em.createQuery(jpql).getResultList();
	    }
	    
	    public List<Empleados> findEmpleados() {
	        String jpql = "FROM Empleados emp WHERE emp.rol = 'empleado' ORDER BY emp.nombre DESC";
	        return (List<Empleados>) em.createQuery(jpql).getResultList();
	    }
	    public List<Empleados>listaClientes(String rol){
			String jpql = "SELECT emp FROM Empleados emp WHERE emp.rol='" + rol + "'";
			List<Empleados>empleados = em.createQuery(jpql).getResultList();
			
			return empleados;
			
		}
		

}
