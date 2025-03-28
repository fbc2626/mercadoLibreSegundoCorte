package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.OficinaPapeleria;

public class OficinaPapeleriaDAO implements OperacionDAO<OficinaPapeleria> {

	private ArrayList<OficinaPapeleria> listaOficinaPapeleria;
	private final String TEXT_FILE_NAME = "papeleria.csv";
	private final String SERIAL_FILE_NAME = "papeleria.dat";

	public OficinaPapeleriaDAO() {
		listaOficinaPapeleria = new ArrayList<>();
		cargarDesdeArchivo();
		cargarArchivoSerializado();

	}

	@Override
	public void crear(OficinaPapeleria nuevoDato) {
		listaOficinaPapeleria.add(nuevoDato);
		escribirEnArchivo(); 
		escribirArchivoSerializado();

	}

	@Override
	public int eliminar(int index) {
		if (index < 0 || index > listaOficinaPapeleria.size()) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 1;
		} else {
			listaOficinaPapeleria.remove(index);
		}
		return 0;
	}

	@Override
	public int eliminar(OficinaPapeleria datoEliminar) {
		if (listaOficinaPapeleria.remove(datoEliminar)) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int actualizar(int index, OficinaPapeleria nuevoDato) {
		if (index < 0 || index > listaOficinaPapeleria.size()) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 1;
		} else {
			listaOficinaPapeleria.set(index, nuevoDato);
		}

		return 0;
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (OficinaPapeleria oficinaPapeleria : listaOficinaPapeleria) {
			salida += oficinaPapeleria.toString();
		}
		return salida;
	}

	public int cantidad() {
		return listaOficinaPapeleria.size();
	}

	public ArrayList<OficinaPapeleria> getListaOficinaPapeleria() {
		return listaOficinaPapeleria;
	}

	public void setListaOficinaPapeleria(ArrayList<OficinaPapeleria> listaOficinaPapeleria) {
		this.listaOficinaPapeleria = listaOficinaPapeleria;
	}

	@Override
	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaOficinaPapeleria.size(); i++) {
			contenido += listaOficinaPapeleria.get(i).getNombre() + ";";
			contenido += listaOficinaPapeleria.get(i).getDescripcion() + ";";
			contenido += listaOficinaPapeleria.get(i).getPrecio() + ";";
			contenido += listaOficinaPapeleria.get(i).getIdentificador() + ";";
			contenido += listaOficinaPapeleria.get(i).getStock() + ";";
			contenido += listaOficinaPapeleria.get(i).getGarantia() + ";";
			contenido += listaOficinaPapeleria.get(i).getCapacidadCarga() + ";";
			contenido += listaOficinaPapeleria.get(i).getConsumoEnergetico() + ";";
			contenido += listaOficinaPapeleria.get(i).getTipoMaterial() + "\n";
		}
		FileManager.escribirArchivoDeTexto(TEXT_FILE_NAME, contenido);
	}

	@Override
	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoDeTexto(TEXT_FILE_NAME);

		if (contenido.isEmpty() || contenido.isBlank()) {
			return;
		}
		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			String nombre = columnas[0];
			String descripcion = columnas[1];
			float precio = Float.parseFloat(columnas[2]);
			int identificador = Integer.parseInt(columnas[3]);
			int stock = Integer.parseInt(columnas[4]);
			int garantia = Integer.parseInt(columnas[5]);
			int capacidadCarga = Integer.parseInt(columnas[6]);
			int consumoEnergetico = Integer.parseInt(columnas[7]);
			String tipoMaterial = columnas[8];

			listaOficinaPapeleria.add(new OficinaPapeleria(nombre, descripcion, precio, identificador, stock, garantia,
					capacidadCarga, consumoEnergetico, tipoMaterial));

		}
	}

	public void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaOficinaPapeleria);
	}

	public void cargarArchivoSerializado() {
		listaOficinaPapeleria = (ArrayList<OficinaPapeleria>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaOficinaPapeleria == null) {
			listaOficinaPapeleria = new ArrayList<>();
		}

	}

}