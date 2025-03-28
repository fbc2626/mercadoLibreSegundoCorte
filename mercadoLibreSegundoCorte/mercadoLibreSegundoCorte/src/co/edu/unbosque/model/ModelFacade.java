package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.HogarBanoDAO;
import co.edu.unbosque.model.persistence.HogarCocinaDAO;
import co.edu.unbosque.model.persistence.OcioDeporteDAO;
import co.edu.unbosque.model.persistence.OcioVideojuegoDAO;
import co.edu.unbosque.model.persistence.OficinaElectrodomesticoDAO;
import co.edu.unbosque.model.persistence.OficinaPapeleriaDAO;

public class ModelFacade {
	private HogarBanoDAO hogarBanoDAO;
	private HogarCocinaDAO hogarCocinaDAO;
	private OcioDeporteDAO ocioDeporteDAO;
	private OcioVideojuegoDAO ocioVideojuegoDAO;
	private OficinaElectrodomesticoDAO oficinaElectrodomesticoDAO;
	private OficinaPapeleriaDAO oficinaPapeleriaDAO;
	private Usuario usuario;
	private ArrayList<Producto> listaProductos;

	public ModelFacade() {
		hogarBanoDAO = new HogarBanoDAO();
		hogarCocinaDAO = new HogarCocinaDAO();
		ocioDeporteDAO = new OcioDeporteDAO();
		ocioVideojuegoDAO = new OcioVideojuegoDAO();
		oficinaElectrodomesticoDAO = new OficinaElectrodomesticoDAO();
		oficinaPapeleriaDAO = new OficinaPapeleriaDAO();
		usuario = new Usuario();
		listaProductos = new ArrayList<>();
	}

	public void eliminarPorId(int id) {
		ArrayList<Producto> aEliminar = new ArrayList<>();
		for (Producto a : listaProductos) {
			if (a.getIdentificador() == id) {
				aEliminar.add(a);
			}
		}
		listaProductos.removeAll(aEliminar);
	}

	public String mostrarTodosLosProductos() {
		listaProductos.clear();
		listaProductos.addAll(hogarBanoDAO.getListaHogarBano());
		listaProductos.addAll(hogarCocinaDAO.getListaHogarCocina());
		listaProductos.addAll(ocioDeporteDAO.getListaOcioDeporte());
		listaProductos.addAll(ocioVideojuegoDAO.getListaOcioVideojuego());
		listaProductos.addAll(oficinaElectrodomesticoDAO.getListaOficinaElectrodomestico());
		listaProductos.addAll(oficinaPapeleriaDAO.getListaOficinaPapeleria());
		String salida = "";
		for (Producto a : listaProductos) {
			salida += a.toString() + "\n";
		}
		return salida;

	}

	public HogarBanoDAO getHogarBanoDAO() {
		return hogarBanoDAO;
	}

	public void setHogarBanoDAO(HogarBanoDAO hogarBanoDAO) {
		this.hogarBanoDAO = hogarBanoDAO;
	}

	public HogarCocinaDAO getHogarCocinaDAO() {
		return hogarCocinaDAO;
	}

	public void setHogarCocinaDAO(HogarCocinaDAO hogarCocinaDAO) {
		this.hogarCocinaDAO = hogarCocinaDAO;
	}

	public OcioDeporteDAO getOcioDeporteDAO() {
		return ocioDeporteDAO;
	}

	public void setOcioDeporteDAO(OcioDeporteDAO ocioDeporteDAO) {
		this.ocioDeporteDAO = ocioDeporteDAO;
	}

	public OcioVideojuegoDAO getOcioVideojuegoDAO() {
		return ocioVideojuegoDAO;
	}

	public void setOcioVideojuegoDAO(OcioVideojuegoDAO ocioVideojuegoDAO) {
		this.ocioVideojuegoDAO = ocioVideojuegoDAO;
	}

	public OficinaElectrodomesticoDAO getOficinaElectrodomesticoDAO() {
		return oficinaElectrodomesticoDAO;
	}

	public void setOficinaElectrodomesticoDAO(OficinaElectrodomesticoDAO oficinaElectrodomesticoDAO) {
		this.oficinaElectrodomesticoDAO = oficinaElectrodomesticoDAO;
	}

	public OficinaPapeleriaDAO getOficinaPapeleriaDAO() {
		return oficinaPapeleriaDAO;
	}

	public void setOficinaPapeleriaDAO(OficinaPapeleriaDAO oficinaPapeleriaDAO) {
		this.oficinaPapeleriaDAO = oficinaPapeleriaDAO;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

}
