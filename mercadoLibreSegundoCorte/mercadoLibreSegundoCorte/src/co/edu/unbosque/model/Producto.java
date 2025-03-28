package co.edu.unbosque.model;

import java.io.Serializable;

public abstract class Producto implements Serializable{

	private String nombre;
	private String descripcion;
	private float precio;
	private int identificador;
	private int stock;
	private int garantia;

	public Producto() {
	}

	public Producto(String nombre, String descripcion, float precio, int identificador, int stock, int garantia) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.identificador = identificador;
		this.stock = stock;
		this.garantia = garantia;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getGarantia() {
		return garantia;
	}

	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}

	@Override
	public String toString() {
		return super.toString() + "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", identificador=" + identificador + ", stock=" + stock + ", garantia=" + garantia + "]";
	}

}
