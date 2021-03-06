package com.inventory.dto;

public class Product 
{
	private String cod_produto;
	private String nombre;
	private String stock;
	private int proveedor_id;
	private int estado;
	private String fecha_creacion;
	private String usu_creacion;
	private String qr_cod;	
	private double precio;
	private int categoria_id;
	private int qty;
	private String location;
	private String warehouse;
	
	public Product()
	{
		
	}
	
	public Product(String cod_produto, String nombre, String stock, int proveedor_id, int estado, String fecha_creacion, String usu_creacion, String qrCod, String qr_cod,double precio,int categoria_id,int qty,String location,String warehouse)
	{
		 this.cod_produto = cod_produto;
	     this.nombre = nombre;
	     this.stock = stock;
	     this.proveedor_id = proveedor_id;
	     this.estado = estado;
	     this.fecha_creacion = fecha_creacion;
	     this.usu_creacion = usu_creacion;
	     this.qr_cod = qr_cod;
	     this.precio = precio;
	     this.categoria_id = categoria_id;
	     this.qty = qty;
	     this.location = location;
	     this.setWarehouse(warehouse);
		
	}
	
	public String getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(String cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getUsu_creacion() {
        return usu_creacion;
    }

    public void setUsu_creacion(String usu_creacion) {
        this.usu_creacion = usu_creacion;
    }
    public String getQr_cod() {
        return qr_cod;
    }

    public void setQr_cod(String qr_cod) {
        this.qr_cod = qr_cod;
    }
    
    public double getPrecio()
    {
    	return precio;
    }
    
    public void setPrecio(double precio)
    {
    	this.precio = precio;
    }

	public int getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}
	
	public int getQty(){
		return qty;
	}
	
	public void setQty(int qty){
		this.qty = qty;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public void setLocation(String location){
		this.location =location;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	
	
	
	

}
