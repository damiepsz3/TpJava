package clases;

import java.util.Date;

public class Reserva {

	private int idlibro;
	private String usuario;
	private Date fechaRetiro;
	private Date fechaEntrega;

	public Reserva(int id, String usuario, Date fechaRetiro, Date fechaEntrega) {
		this.idlibro = id;
		this.usuario = usuario;
		if (fechaRetiro == null) {
			this.fechaRetiro = new Date();
		} else {
			this.fechaRetiro = fechaRetiro;
		}
		this.fechaEntrega = fechaEntrega;
	}

	public int getIdLibro() {
		return this.idlibro;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public Date getFechaRet() {
		return this.fechaRetiro;
	}

	public Date setFechaEntr(){
		return this.fechaEntrega;
	}
}
