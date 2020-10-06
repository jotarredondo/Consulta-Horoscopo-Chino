package com.desafiolatam.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.HoroscopoDTO;


@WebServlet("/ConsultaSigno")
public class ConsultaSigno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ConsultaSigno() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Facade facade = new Facade();
		String fecha = request.getParameter("añoSigno");
		
		//Parseo de datos recibido
		int year = Integer.parseInt(fecha);
		
		// Fórmula para calcular signo zodiaco Chino
		int idSigno = Math.abs((year-1924))%12+1;
		
		//Consulta al método
		HoroscopoDTO respSigno = facade.buscarSigno(idSigno);
		
		//Seteo de respuesta y envío a mostrarSigno
		request.setAttribute("respuestaSigno", respSigno);
		
		RequestDispatcher rd = request.getRequestDispatcher("mostrarSigno.jsp");
		rd.forward(request, response);
		
		
		
	}

}
