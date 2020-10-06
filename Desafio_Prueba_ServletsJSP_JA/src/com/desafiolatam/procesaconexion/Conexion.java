package com.desafiolatam.procesaconexion;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;



public class Conexion {

	//Variables de conexión a la base de datos
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/horoscopo?serverTimezone=UTC";
	private static String usuario = "root";
	private static String pass = "mysql";
	
	private static Conexion dataSource = null;
	private BasicDataSource basicDataSource = null ;
	
	//Pull de conexiones
	private Conexion() {
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(usuario);
		basicDataSource.setPassword(pass);
		
		basicDataSource.setMinIdle(5);
		basicDataSource.setMaxIdle(10);
		basicDataSource.setMaxTotal(50);
		basicDataSource.setMaxWaitMillis(10000);
		
	}
	
	//Patrón singleton
	public static Conexion obtenerConexion() {
		if(dataSource == null) {
			dataSource = new Conexion();
		}
		return dataSource;
	}
	
	//Conexion a través del pull
	public Connection getConexion () throws SQLException {
		return this.basicDataSource.getConnection();
	}
	
	//Cierre de conexion
	public static void cerrarConexion(Connection cnn) throws SQLException {
		cnn.close();
		
	}
}
