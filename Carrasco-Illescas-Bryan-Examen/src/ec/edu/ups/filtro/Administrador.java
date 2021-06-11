package ec.edu.ups.filtro;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.pojos.Empleados;


/**
 * Servlet Filter implementation class Admin
 */
@WebFilter("/WebContent/private/admin/*")
public class Administrador implements Filter {

    /**
     * Default constructor. 
     */
    public Administrador() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		boolean sesion;
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		HttpSession session =  httpReq.getSession(false);

		try {
			Empleados empleados = (Empleados)session.getAttribute("empleado");
			
			sesion = session == null ? false : (Boolean) session.getAttribute("isLogged");
			
			if (sesion) {
				if (empleados.getRol() == "admin") {
					chain.doFilter(request, response);
				}else {
					session.setAttribute("empleado", null);
					session.invalidate();
					httpResp.sendRedirect("/public/IniciarSesion.xhtml");
				}
			}else {
				session.setAttribute("empleado", null);
				session.invalidate();
				httpResp.sendRedirect("/public/IniciarSesion.xhtml");
			}
			
		} catch (Exception e) {
			httpResp.sendRedirect("/public/IniciarSesion.xhtml");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
