package co.edu.unbosque.model;

import java.io.Serializable;

public class OcioDeporte extends ProductoOcio implements Serializable{
	
	private String tipoDeporte;
	private int cantidadComprada;
	
	public OcioDeporte() {
		// TODO Auto-generated constructor stub
	}

	public OcioDeporte(String tipoDeporte) {
		super();
		this.tipoDeporte = tipoDeporte;
	}

	public OcioDeporte(int edadRecomendada, boolean portable, String modoUso, String tipoDeporte) {
		super(edadRecomendada, modoUso);
		this.tipoDeporte = tipoDeporte;
	}

	public OcioDeporte(int edadRecomendada, boolean portable, String modoUso) {
		super(edadRecomendada,  modoUso);
		// TODO Auto-generated constructor stub
	}
	
	public OcioDeporte(String nombre, String descripcion, float precio, int identificador, int stock, int garantia, int edadRecomendada, String modoUso, String tipoDeporte) {
	    super(edadRecomendada, modoUso);
	    setNombre(nombre);
	    setDescripcion(descripcion);
	    setPrecio(precio);
	    setIdentificador(identificador);
	    setStock(stock);
	    setGarantia(garantia);
	    this.tipoDeporte = tipoDeporte;
	}


	@Override
	public String toString() {
		return "OcioDeporte [tipoDeporte=" + tipoDeporte + ", getEdadRecomendada()=" + getEdadRecomendada()
				+ ", getModoUso()=" + getModoUso() + ", toString()="
				+ super.toString() + ", getNombre()=" + getNombre() + ", getDescripcion()=" + getDescripcion()
				+ ", getPrecio()=" + getPrecio() + ", getIdentificador()=" + getIdentificador() + ", getStock()="
				+ getStock() + ", getGarantia()=" + getGarantia() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

	public String getTipoDeporte() {
		return tipoDeporte;
	}

	public void setTipoDeporte(String tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}

	public int getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}
	
}
