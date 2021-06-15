package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;


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
	private String nombre;
	private double precioUnitario;

	public ComidaBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		listaComidas = (List<Comidas>) ejComidaFacade.findAll();
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	
	public String add() {
		ejComidaFacade.create(new Comidas(this.nombre, this.precioUnitario));
		listaComidas = (List<Comidas>) ejComidaFacade.findAll();
		return null;
	}

	public String edit(Comidas comi) {
		comi.setEditable(true);
		return null;
	}

	public String save(Comidas comida) {
		ejComidaFacade.edit(comida);
		comida.setEditable(false);
		return null;
	}

}
