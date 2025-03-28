package co.edu.unbosque.model;

public class Cliente extends Usuario {
	
	private long numeroTelefono;
	private String direccion;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(long numeroTelefono, String direccion) {
		super();
		this.numeroTelefono = numeroTelefono;
		this.direccion = direccion;
	}

	public Cliente(String nombre, String email, String contraseña, long numeroTelefono, String direccion) {
		super(nombre, email, contraseña);
		this.numeroTelefono = numeroTelefono;
		this.direccion = direccion;
	}

	public Cliente(String nombre, String email, String contraseña) {
		super(nombre, email, contraseña);
		// TODO Auto-generated constructor stub
	}

	public long getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(long numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [numeroTelefono=" + numeroTelefono + ", direccion=" + direccion + "]";
	}



}
