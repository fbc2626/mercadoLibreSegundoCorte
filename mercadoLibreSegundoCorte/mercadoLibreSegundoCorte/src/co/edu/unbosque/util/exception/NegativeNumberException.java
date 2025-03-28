package co.edu.unbosque.util.exception;

public class NegativeNumberException extends Exception{
	public NegativeNumberException() {
		super("No se pueden ingresar numeros negativos");
	}
}
