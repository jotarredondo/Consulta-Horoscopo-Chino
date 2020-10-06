package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.desafiolatam.modelo.RegistroDTO;
import com.desafiolatam.procesaconexion.Conexion;

public class RegistroDAO implements InterfaceCRUD <RegistroDTO> {
	
	//Declaro las consultas para la DB y declaro la variable connection
	
	private Connection cnn;
	private final String SQL_INSERT = "INSERT INTO registro(usuario, clave, email,fecha) VALUES (?,?,?,?)";
	private final String SQL_DELETE = "DELETE from registro WHERE usuario = ?";
	private final String SQL_SELECT_ALL = "SELECT usuario, clave, email, fecha FROM registro";
	private final String SQL_SELECT_ID = "SELECT usuario,clave,email, fecha FROM registro WHERE usuario = ?";
	
	
	// Declaro consultas específicas para modificar uno a uno los atributos del registro
	
	private final String SQL_UPDATE_CLAVE = "UPDATE registro SET clave = ? WHERE usuario = ?";
	private final String SQL_UPDATE_EMAIL = "UPDATE registro SET email = ? WHERE usuario = ?";
	private final String SQL_UPDATE_FECHA = "UPDATE registro SET fecha = ? WHERE usuario = ?";
	

	@Override
	public List<RegistroDTO> findAll() {
		
		List<RegistroDTO> registros = new ArrayList<RegistroDTO>();
		PreparedStatement ps;
		ResultSet rs;
	
		try {
			cnn = Conexion.obtenerConexion().getConexion();
			ps = cnn.prepareStatement(SQL_SELECT_ALL);
			rs = ps.executeQuery();
			while(rs.next()) {
				RegistroDTO registroDto = new RegistroDTO();
					registroDto.setUser(rs.getString("usuario"));
					registroDto.setPassword(rs.getString("clave"));
					registroDto.setCorreo(rs.getString("email"));
					registroDto.setFecha(rs.getString("fecha"));
					registros.add(registroDto);	
			}
			Conexion.cerrarConexion(cnn);
			return registros;
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public RegistroDTO findBy (Object user) {
		PreparedStatement ps;
		ResultSet rs;
		RegistroDTO registroDto = null;
		
		try {
			cnn = Conexion.obtenerConexion().getConexion();
			ps = cnn.prepareStatement(SQL_SELECT_ID);
			ps.setString(1,(String)user);
			rs = ps.executeQuery();
			while(rs.next()) {
				registroDto = new RegistroDTO();
				registroDto.setUser(rs.getString("usuario"));
				registroDto.setPassword(rs.getString("clave"));
				registroDto.setCorreo(rs.getString("email"));
				registroDto.setFecha(rs.getString("fecha"));
			}
			Conexion.cerrarConexion(cnn);
			return registroDto;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;		
			
	}

	@Override
	public boolean create(RegistroDTO objeto) {
		PreparedStatement ps;
		
		try {
			cnn = Conexion.obtenerConexion().getConexion();
			ps = cnn.prepareStatement(SQL_INSERT);
			ps.setString(1,objeto.getUser());
			ps.setString(2,objeto.getPassword());
			ps.setString(3,objeto.getCorreo());
			ps.setString(4,objeto.getFecha());

			if(ps.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
				
			e.printStackTrace();
		}
		
		return false;
	}


	
	public boolean updatePassword (RegistroDTO objeto ) {
		PreparedStatement ps;
			
		try {
			cnn = Conexion.obtenerConexion().getConexion();
			ps = cnn.prepareStatement(SQL_UPDATE_CLAVE);
			
			ps.setString(1,objeto.getPassword());
			ps.setString(2,objeto.getUser());
			
			if(ps.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
				
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean updateEmail (RegistroDTO objeto ) {
		PreparedStatement ps;
			
		try {
			cnn = Conexion.obtenerConexion().getConexion();
			ps = cnn.prepareStatement(SQL_UPDATE_EMAIL);
			
			ps.setString(1,objeto.getCorreo());
			ps.setString(2,objeto.getUser());
			
			if(ps.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
				
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean updateFecha(RegistroDTO objeto ) {
		PreparedStatement ps;
			
		try {
			cnn = Conexion.obtenerConexion().getConexion();
			ps = cnn.prepareStatement(SQL_UPDATE_FECHA);
			
			
			ps.setString(1,objeto.getFecha());
			ps.setString(2,objeto.getUser());
			
			if(ps.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
				
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(RegistroDTO objeto) {

		PreparedStatement ps;
		
		try {
			cnn = Conexion.obtenerConexion().getConexion();
			ps= cnn.prepareStatement(SQL_DELETE);
			ps.setString(1,objeto.getUser());
			if(ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(RegistroDTO objeto) {
	
		return false;
	}

	
}
