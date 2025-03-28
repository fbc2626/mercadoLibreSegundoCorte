package co.edu.unbosque.controller;

import co.edu.unbosque.util.exception.ArrayIndexOutOfBoundsException;
import co.edu.unbosque.util.exception.NegativeFloatException;
import co.edu.unbosque.util.exception.NegativeNumberException;
import co.edu.unbosque.util.exception.SymbolException;

public class ExceptionChecker {

	public static void checkNegativeNumber(int entero) throws NegativeNumberException {
		if (entero < 0) {
			throw new NegativeNumberException();
		}
	}
	public static void checkNegativeFloat(float numero) throws NegativeFloatException{
		if(numero<0) {
			throw new NegativeFloatException();
		}
	}
	public static void checkSymbolException(String entrada) throws SymbolException{
		   if (!entrada.matches("[a-zA-Z0-9 ]*"))  {
	            throw new SymbolException();
	        }
	}
	public static void checkArrayIndexOutOfBounds(int a) throws ArrayIndexOutOfBoundsException {
        if (a >= 8) {
            throw new ArrayIndexOutOfBoundsException();
        }
	}
}
