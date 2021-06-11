package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import com.sun.tools.javac.util.List;

import ec.edu.ups.ejb.TarjetaDeCreditoFacade;
import ec.edu.ups.pojos.TarjetaDeCredito;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class TarjetaCreditoBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@EJB
	private TarjetaDeCreditoFacade ejCreditoFacade;
	
	private List<TarjetaDeCredito> listaTarjetas;
	private TarjetaDeCredito tarjetas;
	
	private List<TarjetaDeCredito> listaBuscar;
	
	private int numTarjeta;
	private String nombreTitular;
	private String fechaCaducidad;
	private String codigoVerificacion;
	
	private TarjetaDeCredito tarjeta;
	
	public TarjetaCreditoBean() {
		// TODO Auto-generated constructor stub
	}

	public TarjetaDeCreditoFacade getEjCreditoFacade() {
		return ejCreditoFacade;
	}

	public void setEjCreditoFacade(TarjetaDeCreditoFacade ejCreditoFacade) {
		this.ejCreditoFacade = ejCreditoFacade;
	}

	public List<TarjetaDeCredito> getListaTarjetas() {
		return listaTarjetas;
	}

	public void setListaTarjetas(List<TarjetaDeCredito> listaTarjetas) {
		this.listaTarjetas = listaTarjetas;
	}

	public TarjetaDeCredito getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(TarjetaDeCredito tarjetas) {
		this.tarjetas = tarjetas;
	}

	public List<TarjetaDeCredito> getListaBuscar() {
		return listaBuscar;
	}

	public void setListaBuscar(List<TarjetaDeCredito> listaBuscar) {
		this.listaBuscar = listaBuscar;
	}

	public int getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getCodigoVerificacion() {
		return codigoVerificacion;
	}

	public void setCodigoVerificacion(String codigoVerificacion) {
		this.codigoVerificacion = codigoVerificacion;
	}

	public TarjetaDeCredito getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(TarjetaDeCredito tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	
	
	public List<TarjetaDeCredito> listarTarjetas(){
		listaTarjetas = (List<TarjetaDeCredito>) ejCreditoFacade.findAll();
		return listaTarjetas;
	}
	
	
}
