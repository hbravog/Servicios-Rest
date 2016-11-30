package com.inventory.dto;


public class Inventory 
{
	private int idInventario;
	private String inventario;
	private String fecha;
	private int estado;
	private String usuario;
	
	
	public Inventory()
	{
		
	}


	public int getIdInventario() {
		return idInventario;
	}


	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}


	public String getInventario() {
		return inventario;
	}


	public void setInventario(String inventario) {
		this.inventario = inventario;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	


}
