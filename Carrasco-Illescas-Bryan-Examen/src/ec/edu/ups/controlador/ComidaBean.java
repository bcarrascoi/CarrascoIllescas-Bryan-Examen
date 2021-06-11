package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import com.sun.tools.javac.util.List;

import ec.edu.ups.ejb.ComidaFacade;
import ec.edu.ups.pojos.Comidas;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ComidaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ComidaFacade ejComidaFacade;
	
	private List<Comidas> listaComidas;
	private Comidas comidas;
	
	private List<Comidas> listaBuscar;
	
	private int codigoComida;
	private String nombre;
	private int precioUnitario;
	
	private Comidas comida;
	
	public ComidaBean() {
		// TODO Auto-generated constructor stub
	}

	public ComidaFacade getEjComidaFacade() {
		return ejComidaFacade;
	}

	public void setEjComidaFacade(ComidaFacade ejComidaFacade) {
		this.ejComidaFacade = ejComidaFacade;
	}

	public List<Comidas> getListaComidas() {
		return listaComidas;
	}

	public void setListaComidas(List<Comidas> listaComidas) {
		this.listaComidas = listaComidas;
	}

	public Comidas getComidas() {
		return comidas;
	}

	public void setComidas(Comidas comidas) {
		this.comidas = comidas;
	}

	public List<Comidas> getListaBuscar() {
		return listaBuscar;
	}

	public void setListaBuscar(List<Comidas> listaBuscar) {
		this.listaBuscar = listaBuscar;
	}

	public int getCodigoComida() {
		return codigoComida;
	}

	public void setCodigoComida(int codigoComida) {
		this.codigoComida = codigoComida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Comidas getComida() {
		return comida;
	}

	public void setComida(Comidas comida) {
		this.comida = comida;
	}
	
	
	
}
