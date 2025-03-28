package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.OficinaElectrodomestico;

public class OficinaElectrodomesticoDAO implements OperacionDAO<OficinaElectrodomestico> {

	private ArrayList<OficinaElectrodomestico> listaOficinaElectrodomestico;
	private final String TEXT_FILE_NAME = "electrodomestico.csv";
	private final String SERIAL_FILE_NAME = "electrodomestico.dat";

	public OficinaElectrodomesticoDAO() {

		listaOficinaElectrodomestico = new ArrayList<>();
		cargarDesdeArchivo();
		cargarDesdeArchivoSerializado();

	}

	@Override
	public void crear(OficinaElectrodomestico nuevoDato) {
		listaOficinaElectrodomestico.add(nuevoDato);
		escribirEnArchivo();
		escribirArchivoSerializado();
	}

	@Override
	public int eliminar(int index) {
		if (index < 0 || index > listaOficinaElectrodomestico.size()) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 1;
		} else {
			listaOficinaElectrodomestico.remove(index);
		}
		return 0;
	}

	@Override
	public int eliminar(OficinaElectrodomestico datoEliminar) {
		if (listaOficinaElectrodomestico.remove(datoEliminar)) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int actualizar(int index, OficinaElectrodomestico nuevoDato) {
		if (index < 0 || index > listaOficinaElectrodomestico.size()) {
			cargarDesdeArchivo();
			cargarDesdeArchivoSerializado();
			return 1;
		} else {
			listaOficinaElectrodomestico.set(index, nuevoDato);
		}
		return 0;
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (OficinaElectrodomestico oficinaElectrodomestico : listaOficinaElectrodomestico) {
			salida += oficinaElectrodomestico.toString();
		}
		return salida;
	}

	@Override
	public int cantidad() {
		return listaOficinaElectrodomestico.size();
	}

	public ArrayList<OficinaElectrodomestico> getListaOficinaElectrodomestico() {
		return listaOficinaElectrodomestico;
	}

	public void setListaOficinaElectrodomestico(ArrayList<OficinaElectrodomestico> listaOficinaElectrodomestico) {
		this.listaOficinaElectrodomestico = listaOficinaElectrodomestico;
	}

	@Override
	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaOficinaElectrodomestico.size(); i++) {
			contenido += listaOficinaElectrodomestico.get(i).getNombre() + ";";
			contenido += listaOficinaElectrodomestico.get(i).getDescripcion() + ";";
			contenido += listaOficinaElectrodomestico.get(i).getPrecio() + ";";
			contenido += listaOficinaElectrodomestico.get(i).getIdentificador() + ";";
			contenido += listaOficinaElectrodomestico.get(i).getStock() + ";";
			contenido += listaOficinaElectrodomestico.get(i).getGarantia() + ";";
			contenido += listaOficinaElectrodomestico.get(i).getCapacidadCarga() + ";";
			contenido += listaOficinaElectrodomestico.get(i).getConsumoEnergetico() + ";";
			contenido += listaOficinaElectrodomestico.get(i).getVoltajeRequerido() + "\n";

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
			int voltajeRequerido = Integer.parseInt(columnas[8]);

			listaOficinaElectrodomestico.add(new OficinaElectrodomestico(nombre, descripcion, precio, identificador,
					stock, garantia, capacidadCarga, consumoEnergetico, voltajeRequerido));

		}
	}

	public void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaOficinaElectrodomestico);
	}

	public void cargarDesdeArchivoSerializado() {
		listaOficinaElectrodomestico = (ArrayList<OficinaElectrodomestico>) FileManager
				.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaOficinaElectrodomestico == null) {
			listaOficinaElectrodomestico = new ArrayList<>();
		}
	}

}
