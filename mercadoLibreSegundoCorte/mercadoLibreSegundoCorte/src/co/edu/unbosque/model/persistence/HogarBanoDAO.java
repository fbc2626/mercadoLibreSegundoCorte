package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.HogarBano;
import co.edu.unbosque.model.HogarCocina;

public class HogarBanoDAO implements OperacionDAO<HogarBano> {

	private ArrayList<HogarBano> listaHogarBano;
	private final String TEXT_FILE_NAME = "bano.csv";
	private final String SERIAL_FILE_NAME = "bano.dat";

	public HogarBanoDAO() {
		listaHogarBano = new ArrayList<>();
		cargarDesdeArchivo();
		cargarArchivoSerializado();

	}

	@Override
	public void crear(HogarBano nuevoDato) {
		listaHogarBano.add(nuevoDato);
		escribirEnArchivo();
		escribirArchivoSerializado();

	}

	@Override
	public int eliminar(int index) {

		if (index < 0 || index > listaHogarBano.size()) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 1;
		} else {
			listaHogarBano.remove(index);
		}
		return 0;
	}

	@Override
	public int eliminar(HogarBano datoEliminar) {
		if (listaHogarBano.remove(datoEliminar)) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 0;
		} else {
			return 1;

		}

	}

	@Override
	public int actualizar(int index, HogarBano nuevoDato) {
		if (index < 0 || index > listaHogarBano.size()) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 1;
		} else {
			listaHogarBano.set(index, nuevoDato);
		}
		return 0;
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (HogarBano hogarBano : listaHogarBano) {
			salida += hogarBano.toString();
		}
		return salida;
	}

	public int cantidad() {
		return listaHogarBano.size();
	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaHogarBano.size(); i++) {
			contenido += listaHogarBano.get(i).getNombre() + ";";
			contenido += listaHogarBano.get(i).getDescripcion() + ";";
			contenido += listaHogarBano.get(i).getPrecio() + ";";
			contenido += listaHogarBano.get(i).getIdentificador() + ";";
			contenido += listaHogarBano.get(i).getStock() + ";";
			contenido += listaHogarBano.get(i).getGarantia() + ";";
			contenido += listaHogarBano.get(i).getMaterialPrincipal() + ";";
			contenido += listaHogarBano.get(i).getFragilidad() + ";";
			contenido += listaHogarBano.get(i).isResistenciaHumendad() + "\n";

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
			String materialPrincipal = columnas[6];
			String fragilidad = columnas[7];
			boolean resistenciaHumedad = Boolean.parseBoolean(columnas[8]);

			listaHogarBano.add(new HogarBano(nombre, descripcion, precio, identificador, stock, garantia,
					materialPrincipal, fragilidad, resistenciaHumedad));

		}
	}

	private void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaHogarBano);

	}

	private void cargarArchivoSerializado() {
		listaHogarBano = (ArrayList<HogarBano>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaHogarBano == null) {
			listaHogarBano = new ArrayList<>();
		}
	}

	public ArrayList<HogarBano> getListaHogarBano() {
		return listaHogarBano;
	}

	public void setListaHogarBano(ArrayList<HogarBano> listaHogarBano) {
		this.listaHogarBano = listaHogarBano;
	}

}
