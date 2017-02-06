package controladores.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catalogo.CatalogoUsuarios;
import clases.Usuario;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usr = request.getParameter("username");
		String pass = request.getParameter("password");
		CatalogoUsuarios catUsu = new CatalogoUsuarios();
		Usuario user;
		try {
			user = catUsu.iniciarSesion(usr, pass);
			if (user != null) {

				// devolver usuario

			} else {

				// devolver error

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
