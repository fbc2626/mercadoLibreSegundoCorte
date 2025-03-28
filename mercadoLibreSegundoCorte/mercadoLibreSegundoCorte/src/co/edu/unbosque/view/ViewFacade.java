package co.edu.unbosque.view;

public class ViewFacade {
	private LoginVentana lv;
	private RegistroView rv;
	private VentanaPrincipal vp;

	public ViewFacade() {
		// TODO Auto-generated constructor stub
	}

	public LoginVentana getLv() {
		return lv;
	}

	public void setLv(LoginVentana lv) {
		this.lv = lv;
	}

	public RegistroView getRv() {
		return rv;
	}

	public void setRv(RegistroView rv) {
		this.rv = rv;
	}

	public VentanaPrincipal getVp() {
		return vp;
	}

	public void setVp(VentanaPrincipal vp) {
		this.vp = vp;
	}

}
