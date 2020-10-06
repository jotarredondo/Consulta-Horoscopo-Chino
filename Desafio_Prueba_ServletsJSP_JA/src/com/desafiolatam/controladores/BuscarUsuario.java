package com.desafiolatam.controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.RegistroDTO;

/**
 * Servlet implementation class BuscarUsuario
 */
@WebServlet("/BuscarUsuario")
public class BuscarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public BuscarUsuario() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Instancia de clase y seteo de parámetro
		Facade facade = new Facade();
		String userFind = request.getParameter("nombreFind");
		
		
		//Realizar consulta al método
		RegistroDTO usuario = facade.buscarUsuario(userFind);
		
		
		//Validación de registro
				if (usuario != null) {
					
					//Seteo de variable 
					request.setAttribute("user", usuario);
					
					RequestDispatcher rd = request.getRequestDispatcher("mostrarUsuario.jsp");
					rd.forward(request, response);
					
				} else {
					
					
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Usuario no encontrado');");
					out.println("location='buscarUsuario.jsp';");
					out.println("</script>");
					
					
				}	
	}

}
