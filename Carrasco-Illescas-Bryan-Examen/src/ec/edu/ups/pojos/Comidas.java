package ec.edu.ups.pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comidas implements Serializable {

	@Id
	private int codigo;
	private String nombre;
	private int precioUnitario;
	
	@ManyToOne
	@JoinColumn(name="ped_id" ,nullable = false )
	private Pedido pedido;
	
	public Comidas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comidas(int codigo, String nombre, int precioUnitario, Pedido pedido) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
		this.pedido = pedido;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Comidas [codigo=" + codigo + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario + ", pedido="
				+ pedido + "]";
	}
	
	
	
	
	
}
