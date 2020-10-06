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


@WebServlet("/BorrarUsuario")
public class BorrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BorrarUsuario() {
        super();
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Facade facade = new Facade();
		String nombre = request.getParameter("nombreDelete");
		
		RegistroDTO usuario = facade.buscarUsuario(nombre);
		
		boolean borrar = facade.delete(usuario);
		
		if (borrar == true) {
			
			RequestDispatcher rd = request.getRequestDispatcher("postBorrar.jsp");
			rd.forward(request, response);
						
			
		}else {
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('No se pudo ejecutar la eliminación, vuelva a intentar');");
			out.println("location='preBorrar.jsp';");
			out.println("</script>");
			
			
		}
		
		

	}

}
