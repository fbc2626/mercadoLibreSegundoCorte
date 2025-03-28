package co.edu.unbosque.view;

import java.util.Scanner;

public class Consola {

	private Scanner sc;

	public Consola() {
		
		sc = new Scanner(System.in);
	}

	public int leerEntero() {
		return sc.nextInt();
	}

	
	public long leerLong() {
		return sc.nextLong();
	}

	public double leerDouble() {
		return sc.nextDouble();
	} 

	public float leerFloat() {
		return sc.nextFloat();
	}

	public String leerPalabra() {
		return sc.next();
	}

	public String leerLinea() {
		return sc.nextLine();
	}

	public char leerCharacter() {
		return sc.next().charAt(0);
	}

	public boolean leerBoleano() {
		String entrada = leerPalabra().toLowerCase();

		if (entrada.contains("si")) {
			return true;
		} else {
			return false;
		}

	}

	public void imprimirConSalto(String texto) {
		System.out.println(texto);

	}

	public void imprimirSinSalto(String texto1) {
		System.out.println(texto1);

	}

	public void quemarLinea() {
		sc.nextLine();
	}

}