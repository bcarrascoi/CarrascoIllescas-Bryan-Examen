package ec.edu.ups.controlador;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ComidaFacade;
import ec.edu.ups.ejb.PedidoFacade;
import ec.edu.ups.ejb.TarjetaDeCreditoFacade;
import ec.edu.ups.pojos.Comidas;
import ec.edu.ups.pojos.Pedido;
import ec.edu.ups.pojos.Tarjeta;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private PedidoFacade ejPedidoFacade;
	private List<Pedido> listaPedidos;
	private Date fechaPedido;
	private String nombreCliente;
	private double subtotal;
	private double iva;
	private double total;
	private String observaciones;
	private Tarjeta tarjetaDeCredito;
	private List<Comidas> comidas;
	private Comidas comida;
	@EJB
	private TarjetaDeCreditoFacade ejCreditoFacade;
	@EJB 
	private ComidaFacade ejComidaFacade;
	private List<Tarjeta> listaTarjeta;
	
	private Tarjeta tarjeta;
	private Pedido pedido;
	public PedidoBean() {
		super();
	}
	
	@PostConstruct
	public void init() {
		listaPedidos = (List<Pedido>) ejPedidoFacade.findAll();
		comidas = (List<Comidas>) ejComidaFacade.findAll();
		listaTarjeta = (List<Tarjeta>) ejCreditoFacade.findAll();
		tarjetaDeCredito = new Tarjeta();
	}

	public PedidoFacade getEjPedidoFacade() {
		return ejPedidoFacade;
	}

	public void setEjPedidoFacade(PedidoFacade ejPedidoFacade) {
		this.ejPedidoFacade = ejPedidoFacade;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Tarjeta getTarjetaDeCredito() {
		return tarjetaDeCredito;
	}

	public void setTarjetaDeCredito(Tarjeta tarjetaDeCredito) {
		this.tarjetaDeCredito = tarjetaDeCredito;
	}

	public List<Comidas> getComidas() {
		return comidas;
	}

	public void setComidas(List<Comidas> comidas) {
		this.comidas = comidas;
	}

	public Comidas getComida() {
		return comida;
	}

	public void setComida(Comidas comida) {
		this.comida = comida;
	}

	public TarjetaDeCreditoFacade getEjCreditoFacade() {
		return ejCreditoFacade;
	}

	public void setEjCreditoFacade(TarjetaDeCreditoFacade ejCreditoFacade) {
		this.ejCreditoFacade = ejCreditoFacade;
	}

	public ComidaFacade getEjComidaFacade() {
		return ejComidaFacade;
	}

	public void setEjComidaFacade(ComidaFacade ejComidaFacade) {
		this.ejComidaFacade = ejComidaFacade;
	}

	public List<Tarjeta> getListaTarjeta() {
		return listaTarjeta;
	}

	public void setListaTarjeta(List<Tarjeta> listaTarjeta) {
		this.listaTarjeta = listaTarjeta;
	}
	
	public void guardar() {
		pedido.setFechaPedido((Date) Date.from(Instant.now()));
		ejPedidoFacade.create(pedido);
		tarjeta = new Tarjeta();
		pedido = new Pedido();
		comida = new Comidas();
	}
	/*
	public String add() {
		Pedido ped = new Pedido(0, this.fechaPedido,this.nombreCliente,this.subtotal,this.iva,this.total,this.observaciones,comidas, this.tarjetaDeCredito);
		ArrayList<Comidas> comi = new ArrayList<Comidas>();
		comi.add(comida);
		ped.setComidas(comi);
		if(comida != null) {
			ped.getComidas().add(comida);
			double subtotal = 0;
			for(Comidas comidas : ped.getComidas()) {
				subtotal += comidas.getPrecioUnitario();
			}
			ped.setSubtotal(subtotal);
			ped.setTotal(subtotal-(subtotal * ped.getIva()));
		}
		ejPedidoFacade.create(ped);
		listaPedidos = (List<Pedido>) ejPedidoFacade.findAll();
		return null;
	}*/
	
public void buscarPorTarjeta() {
		
		try {
			if (tarjetaDeCredito != null) {
				
				this.listaPedidos = ejPedidoFacade.buscarNumTarjeta(this.tarjetaDeCredito.getNumTarjeta());
				
				if(listaPedidos.size()==0) {
					this.listaPedidos = ejPedidoFacade.buscarNombreComida(this.tarjetaDeCredito.getNumTarjeta());
					
				}
			} else {
				this.listaPedidos = this.ejPedidoFacade.findAll();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

public void buscarPorNombre() {
	
	try {
		if (ejComidaFacade != null) {
			
			this.listaPedidos = ejPedidoFacade.buscarNombreComida(this.comida.getNombre());
			
			if(listaPedidos.size()==0) {
				this.listaPedidos = ejPedidoFacade.buscarNumTarjeta(this.tarjetaDeCredito.getNumTarjeta());
				
			}
		} else {
			this.listaPedidos = this.ejPedidoFacade.findAll();
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
	public String edit(Pedido c) {
		c.setEditable(true);
		return null;
	}

	public String save(Pedido c) {
		ejPedidoFacade.edit(c);
		c.setEditable(false);
		return null;
	}
	

}
