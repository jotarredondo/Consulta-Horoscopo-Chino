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

@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ModificarUsuario() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Facade facade = new Facade();
		String nombre = request.getParameter("nombreUpdate");
		String clave = request.getParameter("claveUpdate");
		String correo = request.getParameter("correoUpdate");
		String fecha = request.getParameter("fechaUpdate");
		
		RegistroDTO usuario = facade.buscarUsuario(nombre);
		
		if (clave != "") {
		usuario.setPassword(clave);
		facade.modificarClave(usuario);
		}
		
		if (correo != "") {
		usuario.setCorreo(correo);
		facade.modificarCorreo(usuario);
		}
		
		if(fecha != "") {
		usuario.setFecha(fecha);
		facade.modificarFecha(usuario);
		}
		
		boolean claveUpdate = facade.modificarClave(usuario);
		boolean correoUpdate = facade.modificarClave(usuario);
		boolean fechaUpdate = facade.modificarClave(usuario);
		RegistroDTO usuarioUpdate = facade.buscarUsuario(nombre);
		
		if (claveUpdate == true || correoUpdate == true || fechaUpdate == true ) {
			
		
		request.setAttribute("usuario", usuarioUpdate);
		
		RequestDispatcher rd = request.getRequestDispatcher("postModificacion.jsp");
		rd.forward(request, response);
		}else {
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registro no actualizado, vuelva a intentar');");
			out.println("location='preModificarUsuario.jsp';");
			out.println("</script>");
			
//			RequestDispatcher rd = request.getRequestDispatcher("PreModificarUsuario.jsp");
//			rd.forward(request, response);
			
			
		}
	}

}
