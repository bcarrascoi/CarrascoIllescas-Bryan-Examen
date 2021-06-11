package ec.edu.ups.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int numPedido;
	private Date fecha;
	private String nombreCliente;
	private double subtotal;
	private int iva;
	private double total;
	private String observaciones;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "pedido")
	private ArrayList<Comidas> comidas;
	
	@ManyToOne
	@JoinColumn(name="tarjeta_id",nullable = false)
	private TarjetaDeCredito tarjetaDeCredito;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public Pedido(int numPedido, Date fecha, String nombreCliente, double subtotal, int iva, double total, String observaciones,
			ArrayList<Comidas> comidas, TarjetaDeCredito tarjetaDeCredito) {
		super();
		this.numPedido = numPedido;
		this.fecha = fecha;
		this.nombreCliente = nombreCliente;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.observaciones = observaciones;
		this.comidas = comidas;
		this.tarjetaDeCredito = tarjetaDeCredito;
	}

	public int getNumPedido() {
		return numPedido;
	}
	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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

	public ArrayList<Comidas> getComidas() {
		return comidas;
	}

	public void setComidas(ArrayList<Comidas> comidas) {
		this.comidas = comidas;
	}

	public TarjetaDeCredito getTarjetaDeCredito() {
		return tarjetaDeCredito;
	}

	public void setTarjetaDeCredito(TarjetaDeCredito tarjetaDeCredito) {
		this.tarjetaDeCredito = tarjetaDeCredito;
	}

	@Override
	public String toString() {
		return "Pedido [numPedido=" + numPedido + ", fecha=" + fecha + ", nombreCliente=" + nombreCliente + ", subtotal="
				+ subtotal + ", iva=" + iva + ", total=" + total + ", observaciones=" + observaciones + ", comidas="
				+ comidas + ", tarjetaDeCredito=" + tarjetaDeCredito + "]";
	}

	
	
	
}
