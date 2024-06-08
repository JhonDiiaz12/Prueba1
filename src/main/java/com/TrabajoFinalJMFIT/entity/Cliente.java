package com.TrabajoFinalJMFIT.entity;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Clientes")

public class Cliente {

	@Id
	private String id;
	

	private String nombre;
	

	private String apellidos;
	

	private String email;
	
	
	private String peso;
	
	private String estadoPlan = "EN ESPERA";
	

	private String usuario;
	

	private String password;
	
	  private String fechaInicio;
	  
	    private String fechaFin;
	
	
	//CONSTRUCTOR
	public Cliente() {
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPeso() {
		return peso;
	}


	public void setPeso(String peso) {
		this.peso = peso;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEstadoPlan() {
		return estadoPlan;
	}


	public void setEstadoPlan(String estadoPlan) {
		this.estadoPlan = estadoPlan;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	
	
	
	


	
}
