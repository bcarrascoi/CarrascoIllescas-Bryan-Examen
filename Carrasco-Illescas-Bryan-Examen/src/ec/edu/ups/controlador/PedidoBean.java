package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import com.sun.tools.javac.util.List;

import ec.edu.ups.ejb.PedidoFacade;
import ec.edu.ups.pojos.Pedido;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private PedidoFacade ejPedidoFacade;
	
	private List<Pedido> listaPedidos;
	private Pedido pedidos;
	
	private List<Pedido> listaBuscar;
	
	
	private int numPedido;
	private String fecha;
	private String nombreCliente;
	private double subtotal;
	private int iva;
	private double total;
	private String observaciones;
	
	private Pedido pedido;
	
	public PedidoBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		listaPedidos = (List<Pedido>) ejPedidoFacade.findAll();
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

	public Pedido getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedido pedidos) {
		this.pedidos = pedidos;
	}

	public List<Pedido> getListaBuscar() {
		return listaBuscar;
	}

	public void setListaBuscar(List<Pedido> listaBuscar) {
		this.listaBuscar = listaBuscar;
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public String add() {
		ejPedidoFacade.create(new Pedido(0,fecha, nombreCliente, this.numPedido, iva, subtotal, nombreCliente, null, null));
		listaPedidos = (List<Pedido>) ejPedidoFacade.findAll();
	return null;
	}
	

	public List<Pedido> listarPedidos(){
		listaPedidos = (List<Pedido>) ejPedidoFacade.findAll();
		return listaPedidos;
	}
	
}
