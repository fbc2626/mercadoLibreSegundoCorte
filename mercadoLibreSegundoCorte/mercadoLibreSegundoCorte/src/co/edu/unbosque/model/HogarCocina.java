package co.edu.unbosque.model;

import java.io.Serializable;

public class HogarCocina extends ProductoHogar implements Serializable{

private boolean resistenciaCalor;
private int cantidadComprada;
	
	public HogarCocina() {
		// TODO Auto-generated constructor stub
	}

	public HogarCocina(boolean resistenciaCalor) {
		super();
		this.resistenciaCalor = resistenciaCalor;
	}

	public HogarCocina(String nombre, String descripcion, float precio, int identificador, int stock, int garantia,String materialPrincipal, String fragilidad, boolean resistenciaCalor) {
		super(nombre, descripcion, precio, identificador, stock, garantia, materialPrincipal, fragilidad);
		this.resistenciaCalor = resistenciaCalor;
	}

	public HogarCocina(String materialPrincipal, String fragilidad) {
		super(materialPrincipal, fragilidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HogarCocina [resistenciaCalor=" + resistenciaCalor + ", getMaterialPrincipal()=" + getMaterialPrincipal()
				+ ", getFragilidad()=" + getFragilidad() + ", toString()=" + super.toString() + ", getNombre()="
				+ getNombre() + ", getDescripcion()=" + getDescripcion() + ", getPrecio()=" + getPrecio()
				+ ", getIdentificador()=" + getIdentificador() + ", getStock()=" + getStock() + ", getGarantia()="
				+ getGarantia() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	public boolean isResistenciaCalor() {
		return resistenciaCalor;
	}

	public void setResistenciaCalor(boolean resistenciaCalor) {
		this.resistenciaCalor = resistenciaCalor;
	}

	public int getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}
	
	
	

}