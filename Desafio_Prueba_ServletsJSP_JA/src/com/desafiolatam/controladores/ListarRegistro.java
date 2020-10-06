package com.desafiolatam.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.RegistroDTO;

/**
 * Servlet implementation class ListarRegistro
 */
@WebServlet("/ListarRegistro")
public class ListarRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarRegistro() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Instancia la clase facade y llamada al método 
		Facade facade = new Facade();
		List<RegistroDTO> listaUser = facade.listarRegistros();
		
		// Seteo de atributos 
		request.setAttribute("listaUser", listaUser);
		
		RequestDispatcher rd = request.getRequestDispatcher("mostrarUsuarios.jsp");
		rd.forward(request, response);
		
		

	}

}
