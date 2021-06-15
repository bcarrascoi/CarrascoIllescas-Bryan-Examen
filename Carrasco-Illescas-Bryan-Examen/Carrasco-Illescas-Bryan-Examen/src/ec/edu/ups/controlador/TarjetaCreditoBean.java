package ec.edu.ups.controlador;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;


import ec.edu.ups.ejb.TarjetaDeCreditoFacade;
import ec.edu.ups.pojos.Tarjeta;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class TarjetaCreditoBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@EJB
	TarjetaDeCreditoFacade ejCreditoFacade;
	private int numTarjeta;
	private Tarjeta tarjeta;
	private List<Tarjeta> listaTarjeta;
	private String verificacion;
	
	
	public TarjetaCreditoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void generarTarjeta() {
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setCodigoTarjeta(1);
		tarjeta.setNumTarjeta("123456789123");
		tarjeta.setNombreTitular("Juan Perez");
		tarjeta.setFechaCaducidad(new Date(2021,06,15));
		tarjeta.setCodigoVerificacion("777");
		ejCreditoFacade.create(tarjeta);
		
		Tarjeta tarjeta1 = new Tarjeta();
		tarjeta1.setCodigoTarjeta(2);
		tarjeta1.setNumTarjeta("987654321234");
		tarjeta1.setNombreTitular("Bryan Carrasco");
		tarjeta1.setFechaCaducidad(new Date(2021,06,15));
		tarjeta1.setCodigoVerificacion("555");
		ejCreditoFacade.create(tarjeta1);
		
		Tarjeta tarjeta2 = new Tarjeta();
		tarjeta2.setCodigoTarjeta(2);
		tarjeta2.setNumTarjeta("123456789987");
		tarjeta2.setNombreTitular("Patricio Illescas");
		tarjeta2.setFechaCaducidad(new Date(2021,06,15));
		tarjeta2.setCodigoVerificacion("333");
		ejCreditoFacade.create(tarjeta2);
	}
	
	@PostConstruct
	public void init() {
		listaTarjeta = (List<Tarjeta>) ejCreditoFacade.findAll();
	}

	public TarjetaDeCreditoFacade getEjCreditoFacade() {
		return ejCreditoFacade;
	}

	public void setEjCreditoFacade(TarjetaDeCreditoFacade ejCreditoFacade) {
		this.ejCreditoFacade = ejCreditoFacade;
	}

	public int getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public List<Tarjeta> getListaTarjeta() {
		return listaTarjeta;
	}

	public void setListaTarjeta(List<Tarjeta> listaTarjeta) {
		this.listaTarjeta = listaTarjeta;
	}

	public String getVerificacion() {
		return verificacion;
	}

	public void setVerificacion(String verificacion) {
		this.verificacion = verificacion;
	}

	
	
}
