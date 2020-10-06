package com.desafiolatam.modelo;

public class HoroscopoDTO {
	
	private int idSigno;
	private String nombre;
	private String descripcion;
	
	public HoroscopoDTO() {
		super();
	}
	
	public HoroscopoDTO(int idSigno, String nombre, String descripcion) {
		super();
		this.idSigno = idSigno;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdSigno() {
		return idSigno;
	}

	public void setIdSigno(int idSigno) {
		this.idSigno = idSigno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "HoroscopoDTO [IdSigno=" + idSigno + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
}
