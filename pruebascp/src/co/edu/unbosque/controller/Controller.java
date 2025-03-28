package co.edu.unbosque.controller;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.CarritoDeCompra;
import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.view.Consola;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Consola consola;
    private FileManager fileManager;
    private List<Cliente> clientes;
    private Cliente clienteActual;
    private CarritoDeCompra carrito;
    private static final String ARCHIVO_CLIENTES = "clientes.dat";

    public Controller() {
        consola = new Consola();
        fileManager = new FileManager();
        clientes = new ArrayList<>();
        carrito = new CarritoDeCompra();
        cargarClientes();
    }

    public void run() {
        boolean salir = false;
        while (!salir) {
            consola.imprimirConSalto("Bienvenido al Mercado Libre");
            consola.imprimirConSalto("1. Login");
            consola.imprimirConSalto("2. Registrarse");
            consola.imprimirConSalto("3. Ver Carrito");
            consola.imprimirConSalto("4. Agregar Producto al Carrito");
            consola.imprimirConSalto("5. Salir");
            int opcion = consola.leerEntero();

            switch (opcion) {
                case 1:
                    login();
                    break;
                case 2:
                    registrarse();
                    break;
                case 3:
                    verCarrito();
                    break;
                case 4:
                    agregarProductoAlCarrito();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    consola.imprimirConSalto("Opción no válida");
            }
        }
    }

    private void login() {
        consola.imprimirConSalto("Ingrese su email:");
        String email = consola.leerLinea();
        consola.imprimirConSalto("Ingrese su contraseña:");
        String contraseña = consola.leerLinea();

        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email) && cliente.getContraseña().equals(contraseña)) {
                consola.imprimirConSalto("Login exitoso!");
                clienteActual = cliente;
                return;
            }
        }
        consola.imprimirConSalto("Credenciales incorrectas.");
    }

    private void registrarse() {
        consola.imprimirConSalto("Ingrese su nombre:");
        String nombre = consola.leerLinea();
        consola.imprimirConSalto("Ingrese su email:");
        String email = consola.leerLinea();
        String contraseña = "";

        while (true) {
            consola.imprimirConSalto("Ingrese su contraseña (8 caracteres, una mayúscula, un número, un símbolo y una minúscula):");
            contraseña = consola.leerLinea();
            if (validarContraseña(contraseña)) {
                break;
            } else {
                consola.imprimirConSalto("Contraseña no válida. Intente de nuevo.");
            }
        }

        Cliente nuevoCliente = new Cliente(nombre, email, contraseña);
        clientes.add(nuevoCliente);
        guardarClientes();
        consola.imprimirConSalto("Registro exitoso!");
    }

    private boolean validarContraseña(String contraseña) {
        if (contraseña.length() < 8) return false;
        boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecial = false;

        for (char c : contraseña.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            else if (Character.isLowerCase(c)) hasLowerCase = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecial;
    }

    private void verCarrito() {
        if (clienteActual == null) {
            consola.imprimirConSalto("Debe iniciar sesión primero.");
            return;
        }

        consola.imprimirConSalto("Productos en el carrito:");
        for (Producto producto : carrito.getListaProductos()) {
            consola.imprimirConSalto(producto.toString());
        }
        consola.imprimirConSalto("Total: $" + carrito.calcularTotal());
    }

    private void agregarProductoAlCarrito() {
        if (clienteActual == null) {
            consola.imprimirConSalto("Debe iniciar sesión primero.");
            return;
        }

        consola.imprimirConSalto("Ingrese el ID del producto:");
        String id = consola.leerLinea();
        consola.imprimirConSalto("Ingrese el nombre del producto:");
        String nombre = consola.leerLinea();
        consola.imprimirConSalto("Ingrese el precio del producto:");
        double precio = consola.leerDouble();

        Producto producto = new Producto(id, nombre, precio);
        carrito.agregarProducto(producto);
        consola.imprimirConSalto("Producto agregado al carrito.");
    }

    private void cargarClientes() {
        Object contenido = fileManager.leerArchivoSerializado(ARCHIVO_CLIENTES);
        if (contenido instanceof List<?>) {
            clientes = (List<Cliente>) contenido;
        }
    }

    private void guardarClientes() {
        fileManager.escribirArchivoSerializado(ARCHIVO_CLIENTES, clientes);
    }
}
