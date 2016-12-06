package clases;

public class Administrador extends Usuario {

	public Administrador(String user, String pass) {
		super(user, pass);
		// TODO Auto-generated constructor stub
	}

	public String getTipoCuenta(){
		return "Administrador";
	}
}
