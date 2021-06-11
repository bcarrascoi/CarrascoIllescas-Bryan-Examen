package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.annotation.FacesConfig;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.EmpleadoFacade;
import ec.edu.ups.pojos.Empleados;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class EmpleadoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private EmpleadoFacade ejEmpleadoFacade;
    
    private List<Empleados> lista;
    private Empleados empleados;
    
    private List<Empleados> listaBuscar;
    
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String direccion;
    private String pass1;
    private String email1;
    private String estadoCliente;
    private String pass;
    private String email;
    private String rol;
 
    private String cedula1;
    private String cedulaCliente;
    
    private Empleados empleado;
    
	public EmpleadoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
    /*
	@PostConstruct
    public void init() {
		empleados = new Empleados();
		lista = new ArrayList<Empleados>();
		
		listaBuscar= ejEmpleadoFacade.buscarC('A','C');
	}
	*/

	public Empleados[] getLista() {
		return lista.toArray(new Empleados[0]);
	}

	public void setLista(List<Empleados> lista) {
		this.lista = lista;
	}
	

	public List<Empleados> getListaBuscar() {
		return listaBuscar;
	}

	public void setListaBuscar(List<Empleados> listaBuscar) {
		this.listaBuscar = listaBuscar;
	}

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	public String getCedula1() {
		return cedula1;
	}

	public void setCedula1(String cedula1) {
		this.cedula1 = cedula1;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	public EmpleadoFacade getEjEmpleadoFacade() {
		return ejEmpleadoFacade;
	}

	public void setEjEmpleadoFacade(EmpleadoFacade ejEmpleadoFacade) {
		this.ejEmpleadoFacade = ejEmpleadoFacade;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}


public String listarC() {
	String cliente= "cliente";
	lista=ejEmpleadoFacade.listaClientes(cliente);
	return "listarClientes.xhtml";
}
}