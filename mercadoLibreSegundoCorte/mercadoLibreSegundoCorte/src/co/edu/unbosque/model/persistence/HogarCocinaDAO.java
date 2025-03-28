package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.HogarCocina;

public class HogarCocinaDAO implements OperacionDAO<HogarCocina> {

	private ArrayList<HogarCocina> listaHogarCocina;
	private static String TEXT_FILE_NAME = "cocina.csv";
	private static String SERIAL_FILE_NAME = "cocina.dat";

	public HogarCocinaDAO() {
		listaHogarCocina = new ArrayList<>();
		cargarDesdeArchivo();
		cargarArchivoSerializado();
	}

	@Override
	public void crear(HogarCocina nuevoDato) {
		listaHogarCocina.add(nuevoDato);
		escribirEnArchivo();
		escribirArchivoSerializado();

	}

	@Override
	public int eliminar(int index) {
		if (index < 0 || index > listaHogarCocina.size()) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 1;
		} else {
			listaHogarCocina.remove(index);
		}

		return 0;
	}

	@Override
	public int eliminar(HogarCocina datoEliminar) {
		if (listaHogarCocina.remove(datoEliminar)) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 0;
		} else {
			return 1;
		}

	}

	@Override
	public int actualizar(int index, HogarCocina nuevoDato) {
		if (index < 0 || index > listaHogarCocina.size()) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 1;
		} else {
			listaHogarCocina.set(index, nuevoDato);
		}

		return 0;
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (HogarCocina hogarCocina : listaHogarCocina) {
			salida += hogarCocina.toString();
		}

		return salida;
	}

	@Override
	public int cantidad() {
		// TODO Auto-generated method stub
		return listaHogarCocina.size();
	}

	@Override
	public void escribirEnArchivo() {

		String contenido = "";
		for (int i = 0; i < listaHogarCocina.size(); i++) {
			contenido = listaHogarCocina.get(i).getNombre() + ";";
			contenido = listaHogarCocina.get(i).getDescripcion() + ";";
			contenido = listaHogarCocina.get(i).getPrecio() + ";";
			contenido = listaHogarCocina.get(i).getIdentificador() + ";";
			contenido = listaHogarCocina.get(i).getStock() + ";";
			contenido = listaHogarCocina.get(i).getGarantia() + ";";
			contenido = listaHogarCocina.get(i).getMaterialPrincipal() + ";";
			contenido = listaHogarCocina.get(i).getFragilidad() + ";";
			contenido = listaHogarCocina.get(i).isResistenciaCalor() + "\n";

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
			boolean resistenciaCalor = Boolean.parseBoolean(columnas[8]);

			listaHogarCocina.add(new HogarCocina(nombre, descripcion, precio, identificador, stock, garantia,
					materialPrincipal, fragilidad, resistenciaCalor));

		}
	}

	private void cargarArchivoSerializado() {

		listaHogarCocina = (ArrayList<HogarCocina>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaHogarCocina == null) {
			listaHogarCocina = new ArrayList<>();
		}
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaHogarCocina);
	}

	public ArrayList<HogarCocina> getListaHogarCocina() {
		return listaHogarCocina;
	}

	public void setListaHogarCocina(ArrayList<HogarCocina> listaHogarCocina) {
		this.listaHogarCocina = listaHogarCocina;
	}
}
