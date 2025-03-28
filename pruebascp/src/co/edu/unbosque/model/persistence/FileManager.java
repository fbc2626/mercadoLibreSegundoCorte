package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager {

	// Son para archivos de texto
	private static Scanner lectorDeArchivo;
	private static File archivo;
	private static PrintWriter escritorDeArchivo;
	public static final String RUTA_CARPETA = "src/archivos";
	// atributos para serializado
	private static FileOutputStream fos;// sirve para ubicar el archivo
	private static ObjectOutputStream oos;// sirve para escribir objetos
	private static FileInputStream fis;
	private static ObjectInputStream ois;

	public static void crearCarpeta() {

		archivo = new File(RUTA_CARPETA);
		if (!archivo.exists() || !archivo.isDirectory()) {
			archivo.mkdir();
		}

	}

	public static void escribirArchivoDeTexto(String nombreArchivo, String contenido) {

		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			escritorDeArchivo = new PrintWriter(archivo);
			escritorDeArchivo.println(contenido);
			// Cuando se abre un archivo despues de usarlo hay que cerrarlo
			escritorDeArchivo.close();
		} catch (IOException e) {
			// si llegue hasta aqui es porque el archivo no tiene pérmisos/ la url esta mal/
			// el archivo no existe
			System.out.println("Error al escribir el archivo de texto.(Creacion del archivo).");
			e.printStackTrace();
		}
	}

	public static String leerArchivoDeTexto(String nombreArchivo) {
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			lectorDeArchivo = new Scanner(archivo);
			String contenido = "";
			while (lectorDeArchivo.hasNext()) {
				contenido += lectorDeArchivo.nextLine() + " \n";
			}
			lectorDeArchivo.close();
			return contenido;
		}

		catch (IOException e) {
			System.out.println("Error al leer el archivo. (Creacion del archivo)");
			e.printStackTrace();
		}
		return null;
	}

	public static void escribirArchivoSerializado(String nombreArchivo, Object contenido) {
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("Problemas al abrir el archivo serializado (Escritura)");
			e.printStackTrace();
		}
	}
	
	public static Object leerArchivoSerializado(String nombreArchivo) {
		Object contenido = null;
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			contenido = ois.readObject();
			fis.close();
			ois.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo serializado");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error en los datos del archivo serializado");
			e.printStackTrace();
		}
		return contenido;
	}
}