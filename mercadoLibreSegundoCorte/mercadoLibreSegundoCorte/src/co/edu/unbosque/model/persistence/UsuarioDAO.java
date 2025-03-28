package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;

public class UsuarioDAO implements OperacionDAO<Usuario> {

	private ArrayList<Usuario> listaUsuarios;
	private final String TEXT_FILE_NAME = "Usuarios.csv";
	private final String SERIAL_FILE_NAME = "Usuarios.dat";

	public UsuarioDAO() {
		listaUsuarios = new ArrayList<>();
		cargarDesdeArchivo();
		cargarArchivoSerializado();
	}

	@Override
	public void crear(Usuario nuevoDato) {
		listaUsuarios.add(nuevoDato);
		escribirEnArchivo();
		escribirArchivoSerializado();

	}

	@Override
	public int eliminar(int index) {
		if (index < 0 || index > listaUsuarios.size()) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 1;
		} else {
			listaUsuarios.remove(index);
		}
		return 0;
	}

	@Override
	public int eliminar(Usuario datoEliminar) {
		if (listaUsuarios.remove(datoEliminar)) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int actualizar(int index, Usuario nuevoDato) {
		if (index < 0 || index > listaUsuarios.size()) {
			escribirEnArchivo();
			escribirArchivoSerializado();
			return 1;
		} else {
			listaUsuarios.set(index, nuevoDato);
		}

		return 0;
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (Usuario oficinaPapeleria : listaUsuarios) {
			salida += oficinaPapeleria.toString();
		}
		return salida;
	}

	public int cantidad() {
		return listaUsuarios.size();
	}

	@Override
	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaUsuarios.size(); i++) {
			contenido += listaUsuarios.get(i).getNombreUsuario() + ";";
			contenido += listaUsuarios.get(i).getContrasena() + ";";
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
			String nombreUsuario = columnas[0];
			String contraseña = columnas[1];
			listaUsuarios.add(new Usuario(nombreUsuario, contraseña));
		}
	}

	public void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaUsuarios);
	}

	public void cargarArchivoSerializado() {
		listaUsuarios = (ArrayList<Usuario>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaUsuarios == null) {
			listaUsuarios = new ArrayList<>();
		}

	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
