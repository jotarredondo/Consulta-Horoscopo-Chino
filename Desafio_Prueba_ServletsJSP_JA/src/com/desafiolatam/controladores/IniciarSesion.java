package com.desafiolatam.controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.RegistroDTO;



/**
 * Servlet implementation class IniciarSesion
 */
@WebServlet("/IniciarSesion")
public class IniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public IniciarSesion() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Instancia de clase y seteo de parámetro
		Facade facade = new Facade();
		String nombre = request.getParameter("nombreUser");
		String clave = request.getParameter("claveUser");
		
		//Realizar consulta al método
		RegistroDTO registro = facade.buscarUsuario(nombre);
		
		
		//Validación de registro
		if (registro != null && registro.getPassword().equals(clave)) {
			
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("registro", sesion);
			RequestDispatcher rd = request.getRequestDispatcher("preConsulta.jsp");
			rd.forward(request, response);
		} else {
			
			//Impresión de alerta
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Usuario o password incorrecto');");
			out.println("location='index.jsp';");
			out.println("</script>");
			

			
		}
		
		
		
		

	}

}
