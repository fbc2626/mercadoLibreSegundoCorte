package co.edu.unbosque.model;

import java.io.Serializable;

public class OcioVideojuego extends ProductoOcio implements Serializable {

	private String tipoJuego;
	private String plataforma;
	private int cantidadComprada;

	public OcioVideojuego() {
		// TODO Auto-generated constructor stub
	}

	public OcioVideojuego(String tipoJuego, String plataforma) {
		super();
		this.tipoJuego = tipoJuego;
		this.plataforma = plataforma;
	}

 
	public OcioVideojuego(int edadRecomendada, String modoUso) {
		super(edadRecomendada, modoUso);
		// TODO Auto-generated constructor stub
	}

	public OcioVideojuego(String nombre, String descripcion, float precio, int identificador, int stock, int garantia, 
            int edadRecomendada, String modoUso, String tipoJuego, String plataforma) {
super(nombre, descripcion, precio, identificador, stock, garantia, edadRecomendada, modoUso);
this.tipoJuego = tipoJuego;
this.plataforma = plataforma; 
}


	@Override
	public String toString() {
		return "OcioVideojuego [tipoJuego=" + tipoJuego + ", plataforma=" + plataforma + ", getEdadRecomendada()="
				+ getEdadRecomendada() + "getModoUso()=" + getModoUso()
				+ ", toString()=" + super.toString() + ", getNombre()=" + getNombre() + ", getDescripcion()="
				+ getDescripcion() + ", getPrecio()=" + getPrecio() + ", getIdentificador()=" + getIdentificador()
				+ ", getStock()=" + getStock() + ", getGarantia()=" + getGarantia() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	public String getTipoJuego() {
		return tipoJuego;
	}

	public void setTipoJuego(String tipoJuego) {
		this.tipoJuego = tipoJuego;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}

}
