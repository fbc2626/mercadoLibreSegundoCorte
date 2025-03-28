package co.edu.unbosque.model;

import java.io.Serializable;

public abstract class ProductoOcio extends Producto implements Serializable {

    private int edadRecomendada;
    private String modoUso;

    public ProductoOcio() {
    }

    public ProductoOcio(int edadRecomendada, String modoUso) {
        super();
        this.edadRecomendada = edadRecomendada;
        this.modoUso = modoUso;
    }

    // Constructor corregido para recibir los atributos de Producto y ProductoOcio
    public ProductoOcio(String nombre, String descripcion, float precio, int identificador, int stock, int garantia,
                        int edadRecomendada, String modoUso) {
        super(nombre, descripcion, precio, identificador, stock, garantia); // Llamar al constructor de Producto
        this.edadRecomendada = edadRecomendada;
        this.modoUso = modoUso;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }


    public String getModoUso() {
        return modoUso;
    }

    public void setModoUso(String modoUso) {
        this.modoUso = modoUso;
    }

    @Override
    public String toString() {
        return "ProductoOcio [edadRecomendada=" + edadRecomendada + "modoUso=" + modoUso
                + ", " + super.toString() + "]";
    }
}
