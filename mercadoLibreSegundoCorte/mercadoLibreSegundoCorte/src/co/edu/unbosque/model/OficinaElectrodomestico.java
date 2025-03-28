package co.edu.unbosque.model;

import java.io.Serializable;

public class OficinaElectrodomestico extends ProductoOficina implements Serializable {

	private int voltajeRequerido;
	private int cantidadComprada;

	public OficinaElectrodomestico() {
	}

	public OficinaElectrodomestico(int voltajeRequerido) {
		super();
		this.voltajeRequerido = voltajeRequerido;
	}

	public OficinaElectrodomestico(String nombre, String descripcion, float precio, int identificador, int stock,
			int garantia, int capacidadCarga, int consumoEnergetico, int voltajeRequerido) {
		super(nombre, descripcion, precio, identificador, stock, garantia, capacidadCarga, consumoEnergetico);
		this.voltajeRequerido = voltajeRequerido;
	}

	@Override
	public String toString() {
		return "OficinaElectrodomestico [voltajeRequerido=" + voltajeRequerido + ", getCapacidadCarga()="
				+ getCapacidadCarga() + ", getConsumoEnergetico()=" + getConsumoEnergetico() + ", getNombre()="
				+ getNombre() + ", getDescripcion()=" + getDescripcion() + ", getPrecio()=" + getPrecio()
				+ ", getIdentificador()=" + getIdentificador() + ", getStock()=" + getStock() + ", getGarantia()="
				+ getGarantia() + "]";
	}

	public int getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}
	

	public int getVoltajeRequerido() {
		return voltajeRequerido;
	}

	public void setVoltajeRequerido(int voltajeRequerido) {
		this.voltajeRequerido = voltajeRequerido;
	}


}