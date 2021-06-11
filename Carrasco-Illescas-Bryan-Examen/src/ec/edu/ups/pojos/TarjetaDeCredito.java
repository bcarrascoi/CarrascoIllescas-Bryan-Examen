package ec.edu.ups.pojos;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.tools.javac.util.List;

@Entity
public class TarjetaDeCredito implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int numTarjeta;
	private String nombreTitular;
	private Date fechaCaducidad;
	private String codigoVerificacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tarjetaDeCredito")
	private List<Pedido> pedidos;

	public TarjetaDeCredito() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TarjetaDeCredito(int numTarjeta, String nombreTitular, Date fechaCaducidad, String codigoVerificacion,
			List<Pedido> pedidos) {
		super();
		this.numTarjeta = numTarjeta;
		this.nombreTitular = nombreTitular;
		this.fechaCaducidad = fechaCaducidad;
		this.codigoVerificacion = codigoVerificacion;
		this.pedidos = pedidos;
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
	public String toString() {
		return "TarjetaDeCredito [numTarjeta=" + numTarjeta + ", nombreTitular=" + nombreTitular + ", fechaCaducidad="
				+ fechaCaducidad + ", codigoVerificacion=" + codigoVerificacion + ", pedidos=" + pedidos + "]";
	}
	
	
	
}
