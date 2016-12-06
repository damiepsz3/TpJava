package catalogo;

import java.sql.*;
import java.util.ArrayList;

import clases.Libro;
import utils.Conexion;

public class CatalogoLibros {

	public CatalogoLibros() {

	}

	public ArrayList<Libro> getListaLibros() throws Exception {
		Connection con = Conexion.getConexion();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Libro> lista = new ArrayList<Libro>();
		try {
			pst = con.prepareStatement("SELECT * FROM libros ORDER BY nombre");
			rs = pst.executeQuery();

			while (rs.next()) {
				Libro lib = new Libro(rs.getInt("idlibro"), rs.getString("nombre"), rs.getString("autor"));
				lista.add(lib);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (con != null) {
				try {
					Conexion.cerrarConexion();

				} catch (Exception e) {
					System.out.println(e);
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}

		}
		return lista;
	}

	public void eliminarLibro(Libro libro) {

	}

	public void agregarLibro(Libro nuevoLibro) {

	}
}
