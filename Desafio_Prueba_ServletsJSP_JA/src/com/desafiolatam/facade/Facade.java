package com.desafiolatam.facade;

import java.util.List;

import com.desafiolatam.dao.HoroscopoDAO;
import com.desafiolatam.dao.RegistroDAO;
import com.desafiolatam.modelo.HoroscopoDTO;
import com.desafiolatam.modelo.RegistroDTO;


public class Facade {
	
	
	// Implementación de los métodos de la entidad registro
	
	public List <RegistroDTO> listarRegistros (){
		RegistroDAO registroDao = new RegistroDAO();
		return registroDao.findAll();
	}

	public RegistroDTO buscarUsuario (Object user) {
		RegistroDAO registroDao = new RegistroDAO();
		return registroDao.findBy(user);	
	}
	
	public boolean crearUsuario (RegistroDTO registroDto) {
		RegistroDAO registroDao = new RegistroDAO();
		return registroDao.create(registroDto);
	}
	
	public boolean modificarClave (RegistroDTO registroDto) {
		RegistroDAO registroDao = new RegistroDAO();
		return registroDao.updatePassword(registroDto);	
	}
	
	public boolean modificarCorreo (RegistroDTO registroDto) {
		RegistroDAO registroDao = new RegistroDAO();
		return registroDao.updateEmail(registroDto);	
	}
	
	public boolean modificarFecha (RegistroDTO registroDto) {
		RegistroDAO registroDao = new RegistroDAO();
		return registroDao.updateFecha(registroDto);	
	}
	
	public boolean delete (RegistroDTO registroDto) {
		RegistroDAO registroDao = new RegistroDAO();
		return registroDao.delete(registroDto);	
	}
	
	// Implementación de los métodos de la entidad Horoscopo
	
	public List <HoroscopoDTO> listarSignos (){
		HoroscopoDAO horoscopoDao = new HoroscopoDAO();
		return horoscopoDao.findAll();
	}

	public HoroscopoDTO buscarSigno (Object id) {
		HoroscopoDAO horoscopoDao = new  HoroscopoDAO();
		return horoscopoDao.findBy(id);	
	}

}
