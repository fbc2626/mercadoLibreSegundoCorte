package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;
//prueba
public class CarritoDeCompra {

    private float valorTotal;
    private ArrayList<Producto> listaProductos;

    public CarritoDeCompra() {
        this.valorTotal = 0;
        this.listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
        valorTotal += producto.getPrecio();
    }

    public void eliminarProducto(Producto producto) {
        listaProductos.remove(producto);
        valorTotal -= producto.getPrecio();
    }

    public float calcularTotal() {
        return valorTotal;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    @Override
    public String toString() {
        return "CarritoDeCompra [valorTotal=" + valorTotal + ", cantidadProducto=" + listaProductos.size() + "]";
    }
}
