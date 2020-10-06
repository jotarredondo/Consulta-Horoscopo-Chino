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

/**
 * Servlet implementation class CrearCuenta
 */
@WebServlet("/CrearCuenta")
public class CrearCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CrearCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Facade facade = new Facade();
		RegistroDTO registroDto = new RegistroDTO();
		
		// Obtener parámetros del formulario
		
			String nombre = request.getParameter("nombreUser");
			String clave = request.getParameter("claveUser");
			String correo = request.getParameter("correoUser");
			String fecha = request.getParameter("fechaUser");
			
		// Setear datos para ingresarlos
			
			registroDto.setUser(nombre);
			registroDto.setPassword(clave);
			registroDto.setCorreo(correo);
			registroDto.setFecha(fecha);
			
		// Llamar al metodo para enviar datos a BBDD
			
			boolean confirm = facade.crearUsuario(registroDto);
			
			if (confirm == true ) {
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request,response);
				
			}else {
				
				RequestDispatcher rd = request.getRequestDispatcher("crearCuenta.jsp");
				rd.forward(request,response);
				
				
				
			}
			
			
			
			
		
			
		
	}

}
