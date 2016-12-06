package clases;

public class Usuario  {
	private String usuario;
	private String password;
	
	public Usuario(String user, String pass){
		setUsu(user);
		setPass(pass);
	}
	
	public Usuario() {}
	
	public void setUsu(String user){
		this.usuario = user;
	}
	public String getUsu(){
		return usuario;
	}
	
	public void setPass(String pass){
		this.password = pass;
	}
	public String getPass(){
		return password;
	}
	
	public String getTipoCuenta(){
		return "Usuario";
	}
	
}
