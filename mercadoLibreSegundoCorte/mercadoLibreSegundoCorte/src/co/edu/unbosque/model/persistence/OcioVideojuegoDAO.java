package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.OcioVideojuego;

public class OcioVideojuegoDAO implements OperacionDAO<OcioVideojuego> {

	private ArrayList<OcioVideojuego> listaOcioVideojuego;
	private final String TEXT_FILE_NAME = "videojuego.csv";
	private final String SERIAL_FILE_NAME = "videojuego.dat";

	public OcioVideojuegoDAO() {

		listaOcioVideojuego = new ArrayList<>();
		cargarDesdeArchivo();
		cargarArchivoSerializado();
	}

	@Override

	public void crear(OcioVideojuego nuevoDato) {

		listaOcioVideojuego.add(nuevoDato);
		escribirEnArchivo();
		escribirArchivoSerializado();
	}

	@Override
	public int eliminar(int index) {
		if (index < 0 || index > listaOcioVideojuego.size()) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 1;
		} else {
			listaOcioVideojuego.remove(index);
		}
		return 0;
	}

	@Override
	public int eliminar(OcioVideojuego datoEliminar) {

		if (listaOcioVideojuego.remove(datoEliminar)) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 0;
		} else {
			return 1;
		}

	}

	@Override
	public int actualizar(int index, OcioVideojuego nuevoDato) {
		if (index < 0 || index > listaOcioVideojuego.size()) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 1;
		} else {
			listaOcioVideojuego.set(index, nuevoDato);
		}

		return 0;
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (OcioVideojuego ocioVideojuego : listaOcioVideojuego) {
			salida += ocioVideojuego.toString();
		}

		return salida;
	}

	@Override
	public int cantidad() {
		return listaOcioVideojuego.size();
	}

	@Override
	public void escribirEnArchivo() {

		String contenido = "";
		for (int i = 0; i < listaOcioVideojuego.size(); i++) {
			contenido += listaOcioVideojuego.get(i).getNombre() + ";";
			contenido += listaOcioVideojuego.get(i).getDescripcion() + ";";
			contenido += listaOcioVideojuego.get(i).getPrecio() + ";";
			contenido += listaOcioVideojuego.get(i).getIdentificador() + ";";
			contenido += listaOcioVideojuego.get(i).getStock() + ";";
			contenido += listaOcioVideojuego.get(i).getGarantia() + ";";
			contenido += listaOcioVideojuego.get(i).getEdadRecomendada() + ";";
			contenido += listaOcioVideojuego.get(i).getModoUso() + ";";
			contenido += listaOcioVideojuego.get(i).getPlataforma() + ";";
			contenido += listaOcioVideojuego.get(i).getTipoJuego() + "\n";

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
			int edadRecomendada = Integer.parseInt(columnas[6]);
			String modoUso = columnas[7];
			String plataforma = columnas[8];
			String tipoJuego = columnas[9];

			listaOcioVideojuego.add(new OcioVideojuego(nombre, descripcion, precio, identificador, stock, garantia,
					edadRecomendada, modoUso, tipoJuego, plataforma));

		}
	}

	private void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaOcioVideojuego);
	}

	private void cargarArchivoSerializado() {

		listaOcioVideojuego = (ArrayList<OcioVideojuego>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaOcioVideojuego == null) {
			listaOcioVideojuego = new ArrayList<>();
		}
	}

	public ArrayList<OcioVideojuego> getListaOcioVideojuego() {
		return listaOcioVideojuego;
	}

	public void setListaOcioVideojuego(ArrayList<OcioVideojuego> listaOcioVideojuego) {
		this.listaOcioVideojuego = listaOcioVideojuego;
	}

}
