package co.edu.unbosque.model;

import java.io.Serializable;

public abstract class ProductoHogar extends Producto implements Serializable{

	private String materialPrincipal;
	private String fragilidad;
	
	public ProductoHogar() {
		// TODO Auto-generated constructor stub
	}

	public ProductoHogar(String materialPrincipal, String fragilidad) {
		super();
		this.materialPrincipal = materialPrincipal;
		this.fragilidad = fragilidad;
	}
	public ProductoHogar(String nombre, String descripcion, float precio, int identificador, int stock, int garantia, String materialPrincipal, String fragilidad) {
	    super(nombre, descripcion, precio, identificador, stock, garantia);
	    this.materialPrincipal = materialPrincipal;
	    this.fragilidad = fragilidad;
	}


	public String getMaterialPrincipal() {
		return materialPrincipal;
	}

	public void setMaterialPrincipal(String materialPrincipal) {
		this.materialPrincipal = materialPrincipal;
	}

	public String getFragilidad() {
		return fragilidad;
	}

	public void setFragilidad(String fragilidad) {
		this.fragilidad = fragilidad;
	}

	@Override
	public String toString() {
		return super.toString() + "ProductoHogar [materialPrincipal=" + materialPrincipal + ", fragilidad=" + fragilidad + "]";
	}

	
	
	
}
