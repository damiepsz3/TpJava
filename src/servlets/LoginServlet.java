package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import catalogo.CatalogoUsuarios;
import clases.Usuario;


@WebServlet(name="LoginServlet", urlPatterns={"/LoginServlet"})
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
		PrintWriter out = resp.getWriter();
		CatalogoUsuarios catUsu = new CatalogoUsuarios();
		Gson gson = new Gson();
		JsonObject jsObj = new JsonObject();
		try {
			Usuario user = catUsu.iniciarSesion(usr, pass);
			JsonElement userObj = gson.toJsonTree(user);
			if (user != null) {
				jsObj.addProperty("success", true);
			} else {
				jsObj.addProperty("success", false);
			}
			jsObj.add("infoUsu",userObj);
			out.println(jsObj);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
