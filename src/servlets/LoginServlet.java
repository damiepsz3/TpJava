package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catalogo.CatalogoUsuarios;
import clases.Usuario;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -5796755134238754729L;

	/*
	 * METODO DE CONSULTA DE LIBROS
	 * 
	 * @param String username
	 * 
	 * @param String password
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);

		String usr = req.getParameter("username");
		String pass = req.getParameter("password");
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
