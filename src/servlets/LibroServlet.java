package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catalogo.CatalogoLibros;
import clases.Libro;

public class LibroServlet extends HttpServlet {

	private static final long serialVersionUID = 6681153110782196581L;

	/*
	 * METODO DE CONSULTA DE LIBROS
	 * 
	 * @param
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);

		CatalogoLibros catLib = new CatalogoLibros();
		try {
			ArrayList<Libro> libros = catLib.getListaLibros();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * METODO DE ALTA LIBRO
	 * 
	 * @param String titulo
	 * 
	 * @param String autor
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);

		String titulo = req.getParameter("titulo");
		String autor = req.getParameter("autor");
		CatalogoLibros catLib = new CatalogoLibros();
		try {
			catLib.agregarLibro(titulo, autor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}