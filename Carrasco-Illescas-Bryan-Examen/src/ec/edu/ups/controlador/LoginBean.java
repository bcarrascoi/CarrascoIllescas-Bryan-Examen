/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.ejb.EmpleadoFacade;
import ec.edu.ups.pojos.Empleados;
import ec.edu.ups.utilities.Session;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private EmpleadoFacade empleadoFacade;
    private Empleados empleados;
    private String email;
    private String password;

   
    public LoginBean() {
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

    public String login() {
        try {
            if (!email.equals("") && !password.equals("")) {
            	empleados = empleadoFacade.finByEmailAndPass(email, password);
                if (empleados != null) {

                    if (empleados.isActivo()) {
                        //System.out.println("Usuario... " + usuario);

                        HttpSession session =  Session.getSession();
                        session.setAttribute("empleado", empleados);

                        switch (empleados.getRol()) {
                            case "admin":
                                //System.out.println("admin");
                                return "/private/admin/Admin.xhtml?faces-redirect=true";
                            case "empleado":
                                //ystem.out.println("empleado");
                                return "/private/emp/Empleado.xhtml?faces-redirect=true";
                        }
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Su cuenta ah sido desactivada contacte con un administrador"));
                    }

                } else{
                    //System.out.println("Usuario no es correcto");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales incorrectas"));
                }

                //System.out.println("Pass... " + password);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Todos los campos son obligatorios"));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error Interno", "Error! interno intente de nuevo"));
        }
        return "/public/inicio.xhtml";
    }

    public String logout() {
        HttpSession session = Session.getSession();
        session.invalidate();
        return "/public/inicio.xhtml?faces-redirect=true";
    }

    public void checkLogin(String page) {
        FacesContext context = FacesContext.getCurrentInstance();
        Empleados empleadosLogin = (Empleados) Session.getSessionMap().get("empleados");
       
        try {
            if (empleadosLogin == null && page.equals("inicio")) {
                context.getExternalContext().redirect("public/IniciarSesion.xhtml");
            } else if (empleadosLogin != null && page.equals("login")) {
                context.getExternalContext().redirect("../inicio.xhtml");
            }
        } catch (Exception e) {
        }
    }

    public boolean isLogin() {
        Empleados empleadosLogin = (Empleados) Session.getSessionMap().get("empleados");
        if (empleadosLogin != null) {
            return true;
        } else {
            return false;
        }
    }

    public void isAdmin() {
        FacesContext context = FacesContext.getCurrentInstance();
        Empleados empleadosLogin = (Empleados) Session.getSessionMap().get("empleados");
        try {
            if (empleadosLogin == null) {
                context.getExternalContext().redirect("../public/inicio.xhtml");
            } else if (empleadosLogin.getRol().equals("empleado")) {
                context.getExternalContext().redirect("../private/emp/Empleado.xhtml");
            }
        } catch (Exception e) {
        }
    }

    public void isEmpleado() {
        FacesContext context = FacesContext.getCurrentInstance();
        Empleados empleadosLogin = (Empleados) Session.getSessionMap().get("empleados");
        try {
            if (empleadosLogin == null) {
                context.getExternalContext().redirect("../public/inicio.xhtml");
            } else if (empleadosLogin.getRol().equals("admin")) {
                context.getExternalContext().redirect("../private/admin/Admin.xhtml");
            }
        } catch (Exception e) {
        }
    }
    
    public Empleados userLogin(){
        Empleados empleadosLogin = (Empleados) Session.getSessionMap().get("empleados");
        return empleadoFacade.find(empleadosLogin.getCedula());
    }

}
