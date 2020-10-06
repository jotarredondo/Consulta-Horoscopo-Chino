package com.desafiolatam.modelo;


public class RegistroDTO {
	
	private String user;
	private String password;
	private String correo;
	private String fecha;
	
	
	public RegistroDTO() {
		super();
	}
	
	public RegistroDTO(String user, String password, String correo, String fecha) {
		super();
		this.user = user;
		this.password = password;
		this.correo = correo;
		this.fecha = fecha;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "RegistroDTO [user=" + user + ", password=" + password + ", correo=" + correo + ", fecha=" + fecha + "]";
	}		

}
