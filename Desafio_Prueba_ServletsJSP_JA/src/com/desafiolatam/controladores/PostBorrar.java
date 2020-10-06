package com.desafiolatam.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.RegistroDTO;

@WebServlet("/PostBorrar")
public class PostBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public PostBorrar() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Facade facade = new Facade();
		String nombre = request.getParameter("nombreDelete");
		
		RegistroDTO registroDto = new RegistroDTO();
		registroDto.setUser(nombre);
		
		boolean borrar = facade.delete(registroDto);
		
		if (borrar == true) {
			
			RequestDispatcher rd = request.getRequestDispatcher("postBorrar.jsp");
			rd.forward(request, response);
						
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("preBorrar.jsp");
			rd.forward(request, response);
			
			
		}

	}

}
