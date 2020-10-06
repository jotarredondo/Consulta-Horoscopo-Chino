package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.modelo.HoroscopoDTO;
import com.desafiolatam.procesaconexion.Conexion;


public class HoroscopoDAO implements InterfaceCRUD <HoroscopoDTO>{
	
	private Connection cnn;
//	Consultas inactivas, pueden activarse si se necesita modificar la BD
//	private final String SQL_INSERT = "INSERT INTO registro(usuario, clave, email) VALUES (?,?,?)";
//	private final String SQL_UPDATE = "UPDATE registro SET clave =?, email = ? WHERE usuario = ?";
//	private final String SQL_DELETE = "DELETE from curso WHERE usuario = ?";
	
	// Consultas activas para impresión de datos
	private final String SQL_SELECT_ALL = "SELECT id_sign, nombre, descripcion FROM horoscopo";
	private final String SQL_SELECT_ID = "SELECT id_sign, nombre, descripcion FROM horoscopo WHERE id_sign = ?";
	
	//Método para listar todos los signos

	@Override
	public List<HoroscopoDTO> findAll() {
		List<HoroscopoDTO> signos = new ArrayList<HoroscopoDTO>();
		PreparedStatement ps;
		ResultSet rs;
	
		try {
			cnn = Conexion.obtenerConexion().getConexion();
			ps = cnn.prepareStatement(SQL_SELECT_ALL);
			rs = ps.executeQuery();
			while(rs.next()) {
				HoroscopoDTO horoscopoDto = new HoroscopoDTO();
					horoscopoDto.setIdSigno(rs.getInt("id_sign"));
					horoscopoDto.setNombre(rs.getString("nombre"));
					horoscopoDto.setDescripcion(rs.getString("descripcion"));
					signos.add(horoscopoDto);	
			}
			Conexion.cerrarConexion(cnn);
			return signos;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

	
	//Método de busca del signo a través del id
	
	@Override
	public HoroscopoDTO findBy (Object id) {
		PreparedStatement ps;
		ResultSet rs;
		HoroscopoDTO horoscopoDto = null;
		
		try {
			cnn = Conexion.obtenerConexion().getConexion();
			ps = cnn.prepareStatement(SQL_SELECT_ID);
			ps.setInt(1,(int)id);
			rs = ps.executeQuery();
			while(rs.next()) {
				horoscopoDto = new HoroscopoDTO();
				horoscopoDto.setIdSigno(rs.getInt("id_sign"));
				horoscopoDto.setNombre(rs.getString("nombre"));
				horoscopoDto.setDescripcion(rs.getString("descripcion"));	
			}
			Conexion.cerrarConexion(cnn);
			return horoscopoDto;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
			
	}

	
	//Métodos sin implementar de la interface, se puede implementar en caso de actualizar la BD
	
	@Override
	public boolean create(HoroscopoDTO objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(HoroscopoDTO objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(HoroscopoDTO objeto) {
		// TODO Auto-generated method stub
		return false;
	}

}
