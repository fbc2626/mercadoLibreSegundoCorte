package co.edu.unbosque.model.persistence;


public interface OperacionDAO <C>{
	
	
	
public void crear(C nuevoDato);

public int eliminar(int index);


public int eliminar(C datoEliminar);


public int actualizar(int index, C nuevoDato);


public String mostrarTodo();


public int cantidad();

public void escribirEnArchivo();

public void cargarDesdeArchivo();


}
