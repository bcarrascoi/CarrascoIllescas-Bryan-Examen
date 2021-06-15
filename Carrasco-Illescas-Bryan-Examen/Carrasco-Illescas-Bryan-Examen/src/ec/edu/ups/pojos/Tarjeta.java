package ec.edu.ups.pojos;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.sun.tools.javac.util.List;

@Entity
public class Tarjeta implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigoTarjeta;
	private String numTarjeta;
	private String nombreTitular;
	private Date fechaCaducidad;
	private String codigoVerificacion;
	
	@OneToMany
	@JoinColumn
	private List<Pedido> pedidos;
	

	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Tarjeta(int codigoTarjeta, String numTarjeta, String nombreTitular, Date fechaCaducidad,
			String codigoVerificacion, List<Pedido> pedidos) {
		super();
		this.codigoTarjeta = codigoTarjeta;
		this.numTarjeta = numTarjeta;
		this.nombreTitular = nombreTitular;
		this.fechaCaducidad = fechaCaducidad;
		this.codigoVerificacion = codigoVerificacion;
		this.pedidos = pedidos;
	}



	public int getCodigoTarjeta() {
		return codigoTarjeta;
	}


	public void setCodigoTarjeta(int codigoTarjeta) {
		this.codigoTarjeta = codigoTarjeta;
	}


	public String getNumTarjeta() {
		return numTarjeta;
	}


	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}


	public String getNombreTitular() {
		return nombreTitular;
	}


	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}


	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}


	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}


	public String getCodigoVerificacion() {
		return codigoVerificacion;
	}


	public void setCodigoVerificacion(String codigoVerificacion) {
		this.codigoVerificacion = codigoVerificacion;
	}


	public List<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoTarjeta;
		result = prime * result + ((codigoVerificacion == null) ? 0 : codigoVerificacion.hashCode());
		result = prime * result + ((fechaCaducidad == null) ? 0 : fechaCaducidad.hashCode());
		result = prime * result + ((nombreTitular == null) ? 0 : nombreTitular.hashCode());
		result = prime * result + ((numTarjeta == null) ? 0 : numTarjeta.hashCode());
		result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
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
		Tarjeta other = (Tarjeta) obj;
		if (codigoTarjeta != other.codigoTarjeta)
			return false;
		if (codigoVerificacion == null) {
			if (other.codigoVerificacion != null)
				return false;
		} else if (!codigoVerificacion.equals(other.codigoVerificacion))
			return false;
		if (fechaCaducidad == null) {
			if (other.fechaCaducidad != null)
				return false;
		} else if (!fechaCaducidad.equals(other.fechaCaducidad))
			return false;
		if (nombreTitular == null) {
			if (other.nombreTitular != null)
				return false;
		} else if (!nombreTitular.equals(other.nombreTitular))
			return false;
		if (numTarjeta == null) {
			if (other.numTarjeta != null)
				return false;
		} else if (!numTarjeta.equals(other.numTarjeta))
			return false;
		if (pedidos == null) {
			if (other.pedidos != null)
				return false;
		} else if (!pedidos.equals(other.pedidos))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Tarjeta [codigoTarjeta=" + codigoTarjeta + ", numTarjeta=" + numTarjeta + ", nombreTitular="
				+ nombreTitular + ", fechaCaducidad=" + fechaCaducidad + ", codigoVerificacion=" + codigoVerificacion
				+ ", pedidos=" + pedidos + "]";
	}

	
}
