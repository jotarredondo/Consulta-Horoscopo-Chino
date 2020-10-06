package com.desafiolatam.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PreConsulta")
public class PreConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PreConsulta() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Creaci�n de lista de a�os para consultar
		
		List<String> a�os = new ArrayList<String>();
//		int numero;
			for (int i = 1800 ; i < 2020 ; i++ ) {
				
				String a�o = Integer.toString(i);
				a�os.add(a�o);
			}
		//Env�o de lista para imprimir en consulta
			
		request.setAttribute("listaA�os",a�os);
		RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
		rd.forward(request, response);
		
		
	}

}
