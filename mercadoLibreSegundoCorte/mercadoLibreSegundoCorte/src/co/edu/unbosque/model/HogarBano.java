package co.edu.unbosque.model;

import java.io.Serializable;

public class HogarBano extends ProductoHogar implements Serializable {

	private boolean resistenciaHumendad;
	private int cantidadComprada;

	public HogarBano() {
		// TODO Auto-generated constructor stub
	}

	public HogarBano(boolean resistenciaHumendad) {
		super();
		this.resistenciaHumendad = resistenciaHumendad;
	}

	public HogarBano(String nombre, String descripcion, float precio, int identificador, int stock, int garantia,
			String materialPrincipal, String fragilidad, boolean resistenciaHumendad) {
		super(nombre, descripcion, precio, identificador, stock, garantia, materialPrincipal, fragilidad);
		this.resistenciaHumendad = resistenciaHumendad;
	}

	public HogarBano(String materialPrincipal, String fragilidad) {
		super(materialPrincipal, fragilidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HogarBano [resistenciaHumendad=" + resistenciaHumendad + ", getMaterialPrincipal()="
				+ getMaterialPrincipal() + ", getFragilidad()=" + getFragilidad() + ", toString()=" + super.toString()
				+ ", getNombre()=" + getNombre() + ", getDescripcion()=" + getDescripcion() + ", getPrecio()="
				+ getPrecio() + ", getIdentificador()=" + getIdentificador() + ", getStock()=" + getStock()
				+ ", getGarantia()=" + getGarantia() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	public int getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}

	public boolean isResistenciaHumendad() {
		return resistenciaHumendad;
	}

	public void setResistenciaHumendad(boolean resistenciaHumendad) {
		this.resistenciaHumendad = resistenciaHumendad;
	}

}