package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario implements Serializable {
  
    protected String nombre;
    protected String email;
    protected String contraseña;
    
 public Usuario() {
	// TODO Auto-generated constructor stub
}

public Usuario(String nombre, String email, String contraseña) {
	super();
	this.nombre = nombre;
	this.email = email;
	this.contraseña = contraseña;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getContraseña() {
	return contraseña;
}

public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}

@Override
public String toString() {
	return "Usuario [nombre=" + nombre + ", email=" + email + ", contraseña=" + contraseña + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
 
    
    
}