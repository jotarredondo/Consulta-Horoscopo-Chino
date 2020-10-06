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

@WebServlet("/PreBorrar")
public class PreBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PreBorrar() {
        super();
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Instancia de clase y seteo de parámetro
		Facade facade = new Facade();
		
		//Realizar consulta al método Listar Registro
		List<RegistroDTO> usuario = facade.listarRegistros();
		
		
		// Seteo de variable
		request.setAttribute("user", usuario);

		RequestDispatcher rd = request.getRequestDispatcher("borrarUsuario.jsp");
		rd.forward(request, response);
					

	}

}
