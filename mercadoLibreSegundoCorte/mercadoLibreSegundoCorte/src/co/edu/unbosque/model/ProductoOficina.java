package co.edu.unbosque.model;

public abstract class ProductoOficina extends Producto{
	
	private int capacidadCarga;
	private int consumoEnergetico;

	
	public ProductoOficina() {
		// TODO Auto-generated constructor stub
	}


	public ProductoOficina(String nombre, String descripcion, float precio, int identificador, int stock, int garantia, int capacidadCarga, int consumoEnergetico) {
	    super(nombre, descripcion, precio, identificador, stock, garantia); 
	    this.capacidadCarga = capacidadCarga;
	    this.consumoEnergetico = consumoEnergetico;
	}



	public int getCapacidadCarga() {
		return capacidadCarga;
	}


	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}


	public int getConsumoEnergetico() {
		return consumoEnergetico;
	}


	public void setConsumoEnergetico(int consumoEnergetico) {
		this.consumoEnergetico = consumoEnergetico;
	}


	@Override
	public String toString() {
		return "ProductoOficina [capacidadCarga=" + capacidadCarga + ", consumoEnergetico=" + consumoEnergetico + "]";
	}
	
	
}
