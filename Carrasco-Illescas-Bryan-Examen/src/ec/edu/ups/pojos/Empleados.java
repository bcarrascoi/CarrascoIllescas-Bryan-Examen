package ec.edu.ups.pojos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	@Column(unique = true)
	private String email;
	@JsonbTransient
	private String password;
	@JsonbTransient
	private String rol;
	private boolean activo;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
	private ArrayList<Pedido_Cabecera> pedidos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
	private ArrayList<FacturaCabecera> facturas;
	
	@JsonbTransient
    @Transient
    private boolean editable;
	
	public Empleados() {
		super();
		this.activo = true;
		
		// TODO Auto-generated constructor stub
	}
	
	

	public Empleados(int id, String cedula, String nombre, String apellido, String telefono, String direccion,
			String email, String password, String rol) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public ArrayList<Pedido_Cabecera> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido_Cabecera> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<FacturaCabecera> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<FacturaCabecera> facturas) {
		this.facturas = facturas;
	}

	public boolean isActivo(){
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	

	public boolean isEditable() {
		return editable;
	}



	public void setEditable(boolean editable) {
		this.editable = editable;
	}



	@Override
	public String toString() {
		return "Empleados [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email + ", password=" + password
				+ ", rol=" + rol + ", activo=" + activo + "]";
	}

	
	

}
