package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.ViewFacade;
import co.edu.unbosque.view.Consola;
import co.edu.unbosque.view.LoginVentana;
import co.edu.unbosque.view.RegistroView;
import co.edu.unbosque.model.HogarBano;
import co.edu.unbosque.model.HogarCocina;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.OcioDeporte;
import co.edu.unbosque.model.OcioVideojuego;
import co.edu.unbosque.model.OficinaElectrodomestico;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.util.exception.ArrayIndexOutOfBoundsException;
import co.edu.unbosque.util.exception.NegativeFloatException;
import co.edu.unbosque.util.exception.NegativeNumberException;
import co.edu.unbosque.util.exception.SymbolException;

public class Controller {

	private Consola con;
	private VentanaPrincipal vista;
	private LoginVentana loginVista;
	private RegistroView registroVista;
	private ModelFacade mf;
	private ViewFacade vf;
	private ArrayList<Usuario> usuarios;

	public Controller() {
		con = new Consola();
		usuarios = new ArrayList<>();
		mf = new ModelFacade();
		vf = new ViewFacade();
	}

	public void run() {
		cicloinicial: while (true) {
			try {
				while (true) {
					con.imprimirConSalto("Bienvenido a la veterianaria de Mara y Jimmy :)");
					con.imprimirConSalto("Menu inicial");
					con.imprimirConSalto("opcion 1: elegir producto");
					con.imprimirConSalto("opcion 2: salir de la veterinaria");

					int opcion1 = con.leerEntero();
					ExceptionChecker.checkNegativeNumber(opcion1);
					switch (opcion1)

					{
					case 1: {
						cicloelecciondeanimal: while (true) {
							con.imprimirConSalto("1 : Hogar Bano");
							con.imprimirConSalto("2 : gato");
							con.imprimirConSalto("3 : pez");
							con.imprimirConSalto("4 : reptil");
							con.imprimirConSalto("5 : roedor");
							con.imprimirConSalto("6: Mostrar todos los animales ");
							con.imprimirConSalto("7 : Volver");

							int opcion2 = con.leerEntero();
							ExceptionChecker.checkArrayIndexOutOfBounds(opcion2);
							ExceptionChecker.checkNegativeNumber(opcion2);
							switch (opcion2) {
							case 1: {
								ciclofinal: while (true) {
									con.imprimirConSalto("Opciones para Hogar Bano:");
									con.imprimirConSalto("1 : agregar Hogar Bano");
									con.imprimirConSalto("2 : ver lista de Hogar Bano");
									con.imprimirConSalto("3 : borrar un Hogar Bano");
									con.imprimirConSalto("4 : actualizar un Hogar Bano");
									con.imprimirConSalto("5 : volver");

									int opcionHogarBano = con.leerEntero();
									ExceptionChecker.checkNegativeNumber(opcionHogarBano);
									switch (opcionHogarBano) {
									case 1: {
										con.imprimirConSalto("Ingrese la cantidad de productos que va a ingresar");
										int cantidad = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(cantidad);
										for (int i = 0; i < cantidad; i++) {
											con.imprimirConSalto("digite el nombre del producto");
											con.quemarLinea();
											String nombre = con.leerLinea();
											ExceptionChecker.checkSymbolException(nombre);
											con.imprimirConSalto("digite la descripcion del producto");
											String descripcion = con.leerLinea();
											ExceptionChecker.checkSymbolException(descripcion);
											con.imprimirConSalto("digite el precio del producto");
											float precio = con.leerFloat();
											ExceptionChecker.checkNegativeFloat(precio);
											con.imprimirConSalto("digite el identificador del producto");
											int identificador = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(identificador);
											con.imprimirConSalto("Digite la cantidad de productos en stock");
											int stock = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(stock);
											con.imprimirConSalto("Digite la garantia");
											int garantia = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(garantia);
											con.imprimirConSalto("Indique cual es el material principal");
											String materialPrincipal = con.leerLinea();
											ExceptionChecker.checkSymbolException(materialPrincipal);
											con.imprimirConSalto("Indique que tan fragil es");
											String fragilidad = con.leerLinea();
											ExceptionChecker.checkSymbolException(fragilidad);
											con.imprimirConSalto("Indique si es resistente a la humedad");
											Boolean resistenciaHumendad = con.leerBoleano();
											mf.getHogarBanoDAO()
													.crear(new HogarBano(nombre, descripcion, precio, identificador,
															stock, garantia, materialPrincipal, fragilidad,
															resistenciaHumendad));
											con.imprimirConSalto("Hogar bano");
										}
										break;
									}
									case 2: {
										con.imprimirConSalto("Lista de productos de hogar bano registrados:");
										con.imprimirConSalto(mf.getHogarBanoDAO().mostrarTodo());
										break;
									}
									case 3: {
										con.imprimirConSalto(
												"Ingrese la posicion del producto de hogar bano a borrar:");
										int index = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(index);
										mf.getHogarBanoDAO().eliminar(index);
										con.imprimirConSalto("Producto eliminado");
										break;
									}
									case 4: {
										con.imprimirConSalto("digite el perro a modificar:");
										int index = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(index);
										con.imprimirConSalto("digite el nombre del producto");
										con.quemarLinea();
										String nombre = con.leerLinea();
										ExceptionChecker.checkSymbolException(nombre);
										con.imprimirConSalto("digite la descripcion del producto");
										String descripcion = con.leerLinea();
										ExceptionChecker.checkSymbolException(descripcion);
										con.imprimirConSalto("digite el precio del producto");
										float precio = con.leerFloat();
										ExceptionChecker.checkNegativeFloat(precio);
										con.imprimirConSalto("digite el identificador del producto");
										int identificador = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(identificador);
										con.imprimirConSalto("Digite la cantidad de productos en stock");
										int stock = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(stock);
										con.imprimirConSalto("Digite la garantia");
										int garantia = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(garantia);
										con.imprimirConSalto("Indique cual es el material principal");
										String materialPrincipal = con.leerLinea();
										ExceptionChecker.checkSymbolException(materialPrincipal);
										con.imprimirConSalto("Indique que tan fragil es");
										String fragilidad = con.leerLinea();
										ExceptionChecker.checkSymbolException(fragilidad);
										con.imprimirConSalto("Indique si es resistente a la humedad");
										Boolean resistenciaHumendad = con.leerBoleano();
										mf.getHogarBanoDAO()
												.crear(new HogarBano(nombre, descripcion, precio, identificador, stock,
														garantia, materialPrincipal, fragilidad, resistenciaHumendad));
										mf.getHogarBanoDAO().actualizar(index,
												new HogarBano(nombre, descripcion, precio, identificador, stock,
														garantia, materialPrincipal, fragilidad, resistenciaHumendad));
										con.imprimirConSalto("Hogar bano");
										break;
									}
									case 5: {
										break ciclofinal;
									}
									default: {
										break;
									}
									}
								}
								break;
							}

							case 2: {
								cicloojo: while (true) {

									con.imprimirConSalto("1 : agregar hogar cocina");
									con.imprimirConSalto("2 : ver lista de hogar cocina");
									con.imprimirConSalto("3 : borrar un hogar cocina");
									con.imprimirConSalto("4 : actualizar un hogar cocina");
									con.imprimirConSalto("5 : volver");

									int opcionHogarCocina = con.leerEntero();
									ExceptionChecker.checkNegativeNumber(opcionHogarCocina);
									switch (opcionHogarCocina) {
									case 1: {
										con.imprimirConSalto(
												"Ingrese la cantidad de gatos para agregar a la veterinaria");
										int cantidad = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(cantidad);
										for (int i = 0; i < cantidad; i++) {
											con.imprimirConSalto("digite el nombre del producto");
											con.quemarLinea();
											String nombre = con.leerLinea();
											ExceptionChecker.checkSymbolException(nombre);
											con.imprimirConSalto("digite la descripcion del producto");
											String descripcion = con.leerLinea();
											ExceptionChecker.checkSymbolException(descripcion);
											con.imprimirConSalto("digite el precio del producto");
											float precio = con.leerFloat();
											ExceptionChecker.checkNegativeFloat(precio);
											con.imprimirConSalto("digite el identificador del producto");
											int identificador = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(identificador);
											con.imprimirConSalto("Digite la cantidad de productos en stock");
											int stock = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(stock);
											con.imprimirConSalto("Digite la garantia");
											int garantia = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(garantia);
											con.imprimirConSalto("Indique cual es el material principal");
											String materialPrincipal = con.leerLinea();
											ExceptionChecker.checkSymbolException(materialPrincipal);
											con.imprimirConSalto("Indique que tan fragil es");
											String fragilidad = con.leerLinea();
											ExceptionChecker.checkSymbolException(fragilidad);
											con.imprimirConSalto("Indique si es resistente al calor");
											Boolean resistenciaAlCalor = con.leerBoleano();
											mf.getHogarCocinaDAO()
													.crear(new HogarCocina(nombre, descripcion, precio, identificador,
															stock, garantia, materialPrincipal, fragilidad,
															resistenciaAlCalor));
											con.imprimirConSalto("Hogar cocina");
										}
										break;
									}
									case 2: {
										con.imprimirConSalto("Lista de hogar cocina:");
										con.imprimirConSalto(mf.getHogarCocinaDAO().mostrarTodo());
										break;
									}
									case 3: {
										con.imprimirConSalto(
												"Ingrese la posicion del producto de hogar cocina a borrar:");
										int index = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(index);
										mf.getHogarCocinaDAO().eliminar(index);
										con.imprimirConSalto("Producto eliminado");
									}
									case 4: {
										con.imprimirConSalto("digite el gato a actualizar:");
										int index = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(index);
										con.imprimirConSalto("digite el nombre del producto");
										con.quemarLinea();
										String nombre = con.leerLinea();
										ExceptionChecker.checkSymbolException(nombre);
										con.imprimirConSalto("digite la descripcion del producto");
										String descripcion = con.leerLinea();
										ExceptionChecker.checkSymbolException(descripcion);
										con.imprimirConSalto("digite el precio del producto");
										float precio = con.leerFloat();
										ExceptionChecker.checkNegativeFloat(precio);
										con.imprimirConSalto("digite el identificador del producto");
										int identificador = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(identificador);
										con.imprimirConSalto("Digite la cantidad de productos en stock");
										int stock = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(stock);
										con.imprimirConSalto("Digite la garantia");
										int garantia = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(garantia);
										con.imprimirConSalto("Indique cual es el material principal");
										String materialPrincipal = con.leerLinea();
										ExceptionChecker.checkSymbolException(materialPrincipal);
										con.imprimirConSalto("Indique que tan fragil es");
										String fragilidad = con.leerLinea();
										ExceptionChecker.checkSymbolException(fragilidad);
										con.imprimirConSalto("Indique si es resistente al calor");
										Boolean resistenciaAlCalor = con.leerBoleano();
										mf.getHogarCocinaDAO().actualizar(index,
												new HogarCocina(nombre, descripcion, precio, identificador, stock,
														garantia, materialPrincipal, fragilidad, resistenciaAlCalor));
										con.imprimirConSalto("Gato actualizado");
										break;
									}
									case 5: {
										break cicloojo;

									}

									default:
										break;

									}
								}
								break;
							}

							case 3: {
								cicloote: while (true) {

									con.imprimirConSalto("1 : agregar ocio deporte");
									con.imprimirConSalto("2 : ver lista de ocio deporte");
									con.imprimirConSalto("3 : borrar un ocio deporte");
									con.imprimirConSalto("4 : actualizar un ocio deporte");
									con.imprimirConSalto("5 : volver");

									int opcionesPeces = con.leerEntero();
									ExceptionChecker.checkNegativeNumber(opcionesPeces);
									switch (opcionesPeces) {
									case 1: {
										con.imprimirConSalto(
												"Ingrese la cantidad de peces para agregar a la veterinaria");
										int cantidad = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(cantidad);
										for (int i = 0; i < cantidad; i++) {
											con.imprimirConSalto("digite el nombre del producto");
											con.quemarLinea();
											String nombre = con.leerLinea();
											ExceptionChecker.checkSymbolException(nombre);
											con.imprimirConSalto("digite la descripcion del producto");
											String descripcion = con.leerLinea();
											ExceptionChecker.checkSymbolException(descripcion);
											con.imprimirConSalto("digite el precio del producto");
											float precio = con.leerFloat();
											ExceptionChecker.checkNegativeFloat(precio);
											con.imprimirConSalto("digite el identificador del producto");
											int identificador = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(identificador);
											con.imprimirConSalto("Digite la cantidad de productos en stock");
											int stock = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(stock);
											con.imprimirConSalto("Digite la garantia");
											int garantia = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(garantia);
											con.imprimirConSalto("Indique la edad recomendada en numeros");
											int edadRecomendada = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(edadRecomendada);
											con.imprimirConSalto("Indique cual es el material principal");
											String modoUso = con.leerLinea();
											ExceptionChecker.checkSymbolException(modoUso);
											con.imprimirConSalto("Indique que tan fragil es");
											String tipoDeporte = con.leerLinea();
											ExceptionChecker.checkSymbolException(tipoDeporte);
											mf.getOcioDeporteDAO()
													.crear(new OcioDeporte(nombre, descripcion, precio, identificador,
															stock, garantia, edadRecomendada, modoUso, tipoDeporte));
											con.imprimirConSalto("pez guardado");
										}
										break;
									}
									case 2: {
										con.imprimirConSalto("Lista de pez registrados:");
										con.imprimirConSalto(mf.getOcioDeporteDAO().mostrarTodo());
										break;
									}
									case 3: {
										con.imprimirConSalto("digite el pez a eliminar:");
										int index = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(index);
										mf.getOcioDeporteDAO().eliminar(index);
										con.imprimirConSalto("Pez eliminado exitosamente");
										break;
									}
									case 4: {
										con.imprimirConSalto("digite el pez a actualizar:");
										int index = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(index);
										con.imprimirConSalto("digite el nombre del producto");
										con.quemarLinea();
										String nombre = con.leerLinea();
										ExceptionChecker.checkSymbolException(nombre);
										con.imprimirConSalto("digite la descripcion del producto");
										String descripcion = con.leerLinea();
										ExceptionChecker.checkSymbolException(descripcion);
										con.imprimirConSalto("digite el precio del producto");
										float precio = con.leerFloat();
										ExceptionChecker.checkNegativeFloat(precio);
										con.imprimirConSalto("digite el identificador del producto");
										int identificador = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(identificador);
										con.imprimirConSalto("Digite la cantidad de productos en stock");
										int stock = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(stock);
										con.imprimirConSalto("Digite la garantia");
										int garantia = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(garantia);
										con.imprimirConSalto("Indique la edad recomendada en numeros");
										int edadRecomendada = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(edadRecomendada);
										con.imprimirConSalto("Indique cual es el material principal");
										String modoUso = con.leerLinea();
										ExceptionChecker.checkSymbolException(modoUso);
										con.imprimirConSalto("Indique que tan fragil es");
										String tipoDeporte = con.leerLinea();
										ExceptionChecker.checkSymbolException(tipoDeporte);
										mf.getOcioDeporteDAO().actualizar(index,
												new OcioDeporte(nombre, descripcion, precio, identificador, stock,
														garantia, edadRecomendada, modoUso, tipoDeporte));
										con.imprimirConSalto("pez actualizado");
										break;
									}
									case 5: {
										break cicloote;

									}

									default:
										break;

									}
								}
								break;
							}

							case 4: {
								cicloji: while (true) {

									con.imprimirConSalto("1 : agregar ocio videojuego");
									con.imprimirConSalto("2 : ver lista de ocio videojuego");
									con.imprimirConSalto("3 : borrar un ocio videojuego");
									con.imprimirConSalto("4 : actualizar un ocio videojuego");
									con.imprimirConSalto("5 : volver");

									int opcionesReptiles = con.leerEntero();
									ExceptionChecker.checkNegativeNumber(opcionesReptiles);
									switch (opcionesReptiles) {
									case 1: {
										con.imprimirConSalto(
												"Ingrese la cantidad ocio videojuego para agregar a la veterinaria");
										int cantidad = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(cantidad);
										for (int i = 0; i < cantidad; i++) {
											con.imprimirConSalto("digite el nombre del producto");
											con.quemarLinea();
											String nombre = con.leerLinea();
											ExceptionChecker.checkSymbolException(nombre);
											con.imprimirConSalto("digite la descripcion del producto");
											String descripcion = con.leerLinea();
											ExceptionChecker.checkSymbolException(descripcion);
											con.imprimirConSalto("digite el precio del producto");
											float precio = con.leerFloat();
											ExceptionChecker.checkNegativeFloat(precio);
											con.imprimirConSalto("digite el identificador del producto");
											int identificador = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(identificador);
											con.imprimirConSalto("Digite la cantidad de productos en stock");
											int stock = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(stock);
											con.imprimirConSalto("Digite la garantia");
											int garantia = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(garantia);
											con.imprimirConSalto("Indique la edad recomendada en numeros");
											int edadRecomendada = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(edadRecomendada);
											con.imprimirConSalto("Indique cual es su modo de uso");
											String modoUso = con.leerLinea();
											ExceptionChecker.checkSymbolException(modoUso);
											con.imprimirConSalto("Indique que tipo de juego es");
											String tipoJuego = con.leerLinea();
											ExceptionChecker.checkSymbolException(tipoJuego);
											con.imprimirConSalto("Indique la plataforma");
											String plataforma = con.leerLinea();
											ExceptionChecker.checkSymbolException(plataforma);
											mf.getOcioVideojuegoDAO()
													.crear(new OcioVideojuego(nombre, descripcion, precio,
															identificador, stock, garantia, edadRecomendada, modoUso,
															tipoJuego, plataforma));
											con.imprimirConSalto("ocio videojuego guardado");
										}
										break;
									}
									case 2: {
										con.imprimirConSalto("Lista de ocio videojuego registrados:");
										con.imprimirConSalto(mf.getOcioVideojuegoDAO().mostrarTodo());
										break;
									}
									case 3: {
										con.imprimirConSalto("digite el ocio videojuego a eliminar:");
										int index = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(index);
										mf.getOcioVideojuegoDAO().eliminar(index);
										con.imprimirConSalto("ocio videojuego eliminado exitosamente");
										break;
									}
									case 4: {
										con.imprimirConSalto("digite el ocio videojuego a actualizar:");
										int index = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(index);
										con.imprimirConSalto("digite el nombre del producto");
										con.quemarLinea();
										String nombre = con.leerLinea();
										ExceptionChecker.checkSymbolException(nombre);
										con.imprimirConSalto("digite la descripcion del producto");
										String descripcion = con.leerLinea();
										ExceptionChecker.checkSymbolException(descripcion);
										con.imprimirConSalto("digite el precio del producto");
										float precio = con.leerFloat();
										ExceptionChecker.checkNegativeFloat(precio);
										con.imprimirConSalto("digite el identificador del producto");
										int identificador = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(identificador);
										con.imprimirConSalto("Digite la cantidad de productos en stock");
										int stock = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(stock);
										con.imprimirConSalto("Digite la garantia");
										int garantia = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(garantia);
										con.imprimirConSalto("Indique la edad recomendada en numeros");
										int edadRecomendada = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(edadRecomendada);
										con.imprimirConSalto("Indique cual es su modo de uso");
										String modoUso = con.leerLinea();
										ExceptionChecker.checkSymbolException(modoUso);
										con.imprimirConSalto("Indique que tipo de juego es");
										String tipoJuego = con.leerLinea();
										ExceptionChecker.checkSymbolException(tipoJuego);
										con.imprimirConSalto("Indique la plataforma");
										String plataforma = con.leerLinea();
										ExceptionChecker.checkSymbolException(plataforma);
										mf.getOcioVideojuegoDAO().actualizar(index,
												new OcioVideojuego(nombre, descripcion, precio, identificador, stock,
														garantia, edadRecomendada, modoUso, tipoJuego, plataforma));
										con.imprimirConSalto("ocio videojuego actualizado");
										break;
									}
									case 5: {
										break cicloji;

									}

									default:
										break;

									}
								}
								break;
							}

							case 5: {
								ciclot: while (true) {

									con.imprimirConSalto("1 : agregar oficina electrodomestico");
									con.imprimirConSalto("2 : ver lista de oficina electrodomestico");
									con.imprimirConSalto("3 : borrar un oficina electrodomestico");
									con.imprimirConSalto("4 : actualizar un oficina electrodomestico");
									con.imprimirConSalto("5 : volver");

									int opcionesrododeador = con.leerEntero();
									ExceptionChecker.checkNegativeNumber(opcionesrododeador);
									switch (opcionesrododeador) {
									case 1: {
										con.imprimirConSalto(
												"Ingrese la cantidad de rododeadores para agregar a la veterinaria");
										int cantidad = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(cantidad);
										for (int i = 0; i < cantidad; i++) {
											con.imprimirConSalto("digite el nombre del producto");
											con.quemarLinea();
											String nombre = con.leerLinea();
											ExceptionChecker.checkSymbolException(nombre);
											con.imprimirConSalto("digite la descripcion del producto");
											String descripcion = con.leerLinea();
											ExceptionChecker.checkSymbolException(descripcion);
											con.imprimirConSalto("digite el precio del producto");
											float precio = con.leerFloat();
											ExceptionChecker.checkNegativeFloat(precio);
											con.imprimirConSalto("digite el identificador del producto");
											int identificador = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(identificador);
											con.imprimirConSalto("Digite la cantidad de productos en stock");
											int stock = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(stock);
											con.imprimirConSalto("Digite la garantia");
											int garantia = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(garantia);
											con.imprimirConSalto("Indique la capacidad de carga");
											int capacidadCarga = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(capacidadCarga);
											con.imprimirConSalto("Indique el consumo energetico en numeros");
											int consumoEnergetico = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(consumoEnergetico);
											con.imprimirConSalto("Indique el voltaje del producto");
											int voltajeRequerido = con.leerEntero();
											ExceptionChecker.checkNegativeNumber(voltajeRequerido);
											mf.getOficinaElectrodomesticoDAO()
													.crear(new OficinaElectrodomestico(nombre, descripcion, precio,
															identificador, stock, garantia, capacidadCarga,
															consumoEnergetico, voltajeRequerido));
											con.imprimirConSalto("rodeador guardado");
										}
										break;
									}
									case 2: {
										con.imprimirConSalto("Lista de rododeador registrados:");
										con.imprimirConSalto(mf.getOficinaElectrodomesticoDAO().mostrarTodo());
										break;
									}
									case 3: {
										con.imprimirConSalto("digite el rodoeador a eliminar:");
										int index = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(index);
										mf.getOficinaElectrodomesticoDAO().eliminar(index);
										con.imprimirConSalto("rododeador eliminado exitosamente");
										break;
									}
									case 4: {
										con.imprimirConSalto("digite el rododeador a actualizar:");
										int index = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(index);
										con.imprimirConSalto("digite el nombre del producto");
										con.quemarLinea();
										String nombre = con.leerLinea();
										ExceptionChecker.checkSymbolException(nombre);
										con.imprimirConSalto("digite la descripcion del producto");
										String descripcion = con.leerLinea();
										ExceptionChecker.checkSymbolException(descripcion);
										con.imprimirConSalto("digite el precio del producto");
										float precio = con.leerFloat();
										ExceptionChecker.checkNegativeFloat(precio);
										con.imprimirConSalto("digite el identificador del producto");
										int identificador = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(identificador);
										con.imprimirConSalto("Digite la cantidad de productos en stock");
										int stock = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(stock);
										con.imprimirConSalto("Digite la garantia");
										int garantia = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(garantia);
										con.imprimirConSalto("Indique la capacidad de carga");
										int capacidadCarga = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(capacidadCarga);
										con.imprimirConSalto("Indique el consumo energetico en numeros");
										int consumoEnergetico = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(consumoEnergetico);
										con.imprimirConSalto("Indique el voltaje del producto");
										int voltajeRequerido = con.leerEntero();
										ExceptionChecker.checkNegativeNumber(voltajeRequerido);
										mf.getOficinaElectrodomesticoDAO().actualizar(index,
												new OficinaElectrodomestico(nombre, descripcion, precio, identificador,
														stock, garantia, capacidadCarga, consumoEnergetico,
														voltajeRequerido));
										con.imprimirConSalto("roedor actualizado");
										break;
									}
									case 5: {
										break ciclot;

									}

									default:
										break;

									}
								}
								break;
							}

							case 6: {
								if (mf.getListaProductos().isEmpty()) {
									con.imprimirConSalto(mf.mostrarTodosLosProductos());
								} else {
									con.imprimirConSalto(mf.mostrarTodosLosProductos());
								}
								break;
							}
							case 7: {
								break cicloelecciondeanimal;
							}
							default: {
								break;
							}
							}
						}
					}
					case 2: {
						break cicloinicial;
					}
					default: {
						System.out.println("Ingrese un numero valido");
						break;
					}
					}
				}
			} catch (InputMismatchException e) {
				con.imprimirConSalto("Valor no aceptado");
			} catch (NegativeNumberException e) {
				con.imprimirConSalto("No se puede ingresar un valor negativo");
			} catch (NegativeFloatException e) {
				con.imprimirConSalto("No se puede ingresar un valor negativo");
			} catch (SymbolException e) {
				con.imprimirConSalto("No se puden meter simbolos");
			} catch (ArrayIndexOutOfBoundsException e) {
				con.imprimirConSalto("Valor fuera del limite");
			}
		}
	}

	private void initLoginListeners() {
		loginVista.getBtnIngresar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = loginVista.getCampoUsuario().getText();
				String contrasena = String.valueOf(loginVista.getCampoContrasena().getPassword());

				if (usuario.isEmpty() || contrasena.isEmpty()) {
					loginVista.getMensajeError().setText("Usuario y contraseña requeridos");
				} else if (!validarCredenciales(usuario, contrasena)) {
					loginVista.getMensajeError().setText(" Usuario o contraseña incorrectos.");
				} else {
					JOptionPane.showMessageDialog(loginVista, "Acceso concedido ");
					loginVista.dispose();
					abrirVentanaPrincipal();
				}
			}
		});

		loginVista.getBtnRegistrarse().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirRegistro();
			}
		});
	}

	private void abrirRegistro() {
		registroVista = new RegistroView();
		registroVista.setVisible(true);
		initRegistroListeners();
	}

	private void initRegistroListeners() {
		registroVista.getBtnRegistrar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = registroVista.getCampoUsuario().getText();
				String contrasena = String.valueOf(registroVista.getCampoContrasena().getPassword());
				String confirmarContrasena = String.valueOf(registroVista.getCampoConfirmarContrasena().getPassword());

				if (usuario.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
					registroVista.getMensajeError().setText(" Todos los campos son obligatorios.");
				} else if (!validarContrasena(contrasena)) {
					registroVista.getMensajeError().setText(
							" La contraseña debe tener 8 caracteres, una mayúscula, una minúscula, un número y un símbolo.");
				} else if (!contrasena.equals(confirmarContrasena)) {
					registroVista.getMensajeError().setText(" Las contraseñas no coinciden.");
				} else if (existeUsuario(usuario)) {
					registroVista.getMensajeError().setText(" Este usuario ya está registrado.");
				} else {
					usuarios.add(new Usuario(usuario, contrasena));
					JOptionPane.showMessageDialog(registroVista, "Registro exitoso ");
					registroVista.dispose();
				}
			}
		});

		registroVista.getBtnCancelar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registroVista.dispose();
			}
		});
	}

	private boolean validarCredenciales(String usuario, String contrasena) {
		for (Usuario u : usuarios) {
			if (u.getNombreUsuario().equals(usuario) && u.getContrasena().equals(contrasena)) {
				return true;
			}
		}
		return false;
	}

	private boolean existeUsuario(String usuario) {
		for (Usuario u : usuarios) {
			if (u.getNombreUsuario().equals(usuario)) {
				return true;
			}
		}
		return false;
	}

	private boolean validarContrasena(String contrasena) {
		String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
		return Pattern.matches(regex, contrasena);
	}

	private void abrirVentanaPrincipal() {
		vista = new VentanaPrincipal();
		vista.setVisible(true);
		initListeners();
	}

	private void initListeners() {
		vista.getBtnAgregarHogar()
				.addActionListener(e -> JOptionPane.showMessageDialog(vista, "¡Producto de Hogar añadido al carrito!"));
		vista.getBtnAgregarOcio()
				.addActionListener(e -> JOptionPane.showMessageDialog(vista, "¡Producto de Ocio añadido al carrito!"));
		vista.getBtnAgregarOficina().addActionListener(
				e -> JOptionPane.showMessageDialog(vista, "¡Producto de Oficina añadido al carrito!"));
		vista.getBtnVerCarrito()
				.addActionListener(e -> JOptionPane.showMessageDialog(vista, "Mostrando Carrito de Compras"));
	}

	public static void main(String[] args) {
		new Controller().run();
	}
//    public void crearProductosIniciales() {
//    	mf.getHogarBanoDAO().crear(new HogarBano(null, null, 0, 0, 0, 0, null, null, false));
//    }
}
