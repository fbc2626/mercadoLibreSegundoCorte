package co.edu.unbosque.util.exception;

public class NegativeFloatException extends Exception{
	public NegativeFloatException() {
		super("Tiene que ser un numero positivo");
	}
}
