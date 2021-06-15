package ec.edu.ups.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numPedido;
	private Date fechaPedido;
	private String nombreCliente;
	private double subtotal;
	private double iva;
	private double total;
	private String observaciones;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Comidas> comidas;
	
	@ManyToOne
	@JoinColumn
	private Tarjeta tarjetaDeCredito;
	@Transient 
	private boolean editable;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public Pedido(int numPedido, Date fechaPedido, String nombreCliente, double subtotal, double iva, double total,
			String observaciones, List<Comidas> comidas, Tarjeta tarjetaDeCredito) {
		super();
		this.numPedido = numPedido;
		this.fechaPedido = fechaPedido;
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

	public List<Comidas> getComidas() {
		return comidas;
	}

	public void setComidas(List<Comidas> comidas) {
		this.comidas = comidas;
	}

	public Tarjeta getTarjetaDeCredito() {
		return tarjetaDeCredito;
	}

	public void setTarjetaDeCredito(Tarjeta tarjetaDeCredito) {
		this.tarjetaDeCredito = tarjetaDeCredito;
	}

	public boolean isEditable() {
		return editable;
	}
	
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comidas == null) ? 0 : comidas.hashCode());
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + ((fechaPedido == null) ? 0 : fechaPedido.hashCode());
		long temp;
		temp = Double.doubleToLongBits(iva);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nombreCliente == null) ? 0 : nombreCliente.hashCode());
		result = prime * result + numPedido;
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		temp = Double.doubleToLongBits(subtotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tarjetaDeCredito == null) ? 0 : tarjetaDeCredito.hashCode());
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (comidas == null) {
			if (other.comidas != null)
				return false;
		} else if (!comidas.equals(other.comidas))
			return false;
		if (editable != other.editable)
			return false;
		if (fechaPedido == null) {
			if (other.fechaPedido != null)
				return false;
		} else if (!fechaPedido.equals(other.fechaPedido))
			return false;
		if (Double.doubleToLongBits(iva) != Double.doubleToLongBits(other.iva))
			return false;
		if (nombreCliente == null) {
			if (other.nombreCliente != null)
				return false;
		} else if (!nombreCliente.equals(other.nombreCliente))
			return false;
		if (numPedido != other.numPedido)
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (Double.doubleToLongBits(subtotal) != Double.doubleToLongBits(other.subtotal))
			return false;
		if (tarjetaDeCredito == null) {
			if (other.tarjetaDeCredito != null)
				return false;
		} else if (!tarjetaDeCredito.equals(other.tarjetaDeCredito))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [numPedido=" + numPedido + ", fechaPedido=" + fechaPedido + ", nombreCliente=" + nombreCliente
				+ ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", observaciones=" + observaciones
				+ ", comidas=" + comidas + ", tarjetaDeCredito=" + tarjetaDeCredito + ", editable=" + editable + "]";
	}
	
}
