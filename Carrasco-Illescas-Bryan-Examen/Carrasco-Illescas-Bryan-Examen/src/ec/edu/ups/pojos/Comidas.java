package ec.edu.ups.pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Comidas implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int codigoComida;
	private String nombre;
	private double precioUnitario;
	
	@ManyToOne
	private Pedido pedido;
	@Transient
	private boolean editable;
	
	
	public Comidas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comidas(String nombre, double precioUnitario) {
		super();
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
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

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public boolean isEditable() {
		return editable;
	}
	
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoComida;
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precioUnitario);
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
		Comidas other = (Comidas) obj;
		if (codigoComida != other.codigoComida)
			return false;
		if (editable != other.editable)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (Double.doubleToLongBits(precioUnitario) != Double.doubleToLongBits(other.precioUnitario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comidas [codigoComida=" + codigoComida + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario
				+ ", pedido=" + pedido + ", editable=" + editable + "]";
	}

	
	
}
