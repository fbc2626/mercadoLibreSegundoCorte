package co.edu.unbosque.model;

import java.io.Serializable;

public class OficinaPapeleria extends ProductoOficina implements Serializable {
    
    private String tipoMaterial;
    private int cantidadComprada;

    // Constructor vacío
    public OficinaPapeleria() {
    }

    // Constructor con solo tipoMaterial
    public OficinaPapeleria(String tipoMaterial) {
        super();
        this.tipoMaterial = tipoMaterial;
    }

    // Constructor completo
    public OficinaPapeleria(String nombre, String descripcion, float precio, int identificador, int stock, int garantia, 
                            int capacidadCarga, int consumoEnergetico, String tipoMaterial) {
        super(nombre, descripcion, precio, identificador, stock, garantia, capacidadCarga, consumoEnergetico);
        this.tipoMaterial = tipoMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    @Override
    public String toString() {
        return "OficinaPapeleria [tipoMaterial=" + tipoMaterial + ", getCapacidadCarga()=" + getCapacidadCarga()
                + ", getConsumoEnergetico()=" + getConsumoEnergetico() + ", getNombre()=" + getNombre()
                + ", getDescripcion()=" + getDescripcion() + ", getPrecio()=" + getPrecio()
                + ", getIdentificador()=" + getIdentificador() + ", getStock()=" + getStock()
                + ", getGarantia()=" + getGarantia() + "]";
    }

	public int getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}
    
    
}
