package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.OcioDeporte;

public class OcioDeporteDAO implements OperacionDAO<OcioDeporte> {

	private ArrayList<OcioDeporte> listaOcioDeporte;
	private final String TEXT_FILE_NAME = "deporte.csv";
	private final String SERIAL_FILE_NAME = "deporte.dat";

	public OcioDeporteDAO() {
		listaOcioDeporte = new ArrayList<>();
		cargarDesdeArchivo();
		cargarArchivoSerializado();
	}

	@Override
	public void crear(OcioDeporte nuevoDato) {
		listaOcioDeporte.add(nuevoDato);
		cargarDesdeArchivo();
		cargarArchivoSerializado();
	}

	@Override
	public int eliminar(int index) {
		if (index < 0 || index > listaOcioDeporte.size()) {
			escribirEnArchivo();
			escribirEnArchivo();
			return 1;
		} else {
			listaOcioDeporte.remove(index);
		}
		return 0;
	}

	@Override
	public int eliminar(OcioDeporte datoEliminar) {
		if (listaOcioDeporte.remove(datoEliminar)) {
			escribirEnArchivo();
			escribirEnArchivoSerializado();
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int actualizar(int index, OcioDeporte nuevoDato) {
		if (index < 0 || index > listaOcioDeporte.size()) {
			escribirEnArchivo();
			escribirEnArchivoSerializado();
			return 1;
		} else {
			listaOcioDeporte.set(index, nuevoDato);
		}

		return 0;
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (OcioDeporte ocioDeporte : listaOcioDeporte) {
			salida += ocioDeporte.toString();
		}

		return salida;
	}

	@Override
	public int cantidad() {
		return listaOcioDeporte.size();
	}

	@Override
	public void escribirEnArchivo() {

		String contenido = "";
		for (int i = 0; i < listaOcioDeporte.size(); i++) {
			contenido += listaOcioDeporte.get(i).getNombre() + ";";
			contenido += listaOcioDeporte.get(i).getDescripcion() + ";";
			contenido += listaOcioDeporte.get(i).getPrecio() + ";";
			contenido += listaOcioDeporte.get(i).getIdentificador() + ";";
			contenido += listaOcioDeporte.get(i).getStock() + ";";
			contenido += listaOcioDeporte.get(i).getGarantia() + ";";
			contenido += listaOcioDeporte.get(i).getEdadRecomendada() + ";";
			contenido += listaOcioDeporte.get(i).getModoUso() + ";";
			contenido += listaOcioDeporte.get(i).getTipoDeporte() + "\n";

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
			String tipoDeporte = columnas[8];

			listaOcioDeporte.add(new OcioDeporte(nombre, descripcion, precio, identificador, stock, garantia,
					edadRecomendada, modoUso, tipoDeporte));

		}
	}

	private void cargarArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaOcioDeporte);
	}

	private void escribirEnArchivoSerializado() {
		listaOcioDeporte = (ArrayList<OcioDeporte>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaOcioDeporte == null) {
			listaOcioDeporte = new ArrayList<>();
		}

	}

	public ArrayList<OcioDeporte> getListaOcioDeporte() {
		return listaOcioDeporte;
	}

	public void setListaOcioDeporte(ArrayList<OcioDeporte> listaOcioDeporte) {
		this.listaOcioDeporte = listaOcioDeporte;
	}

}
