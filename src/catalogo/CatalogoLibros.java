package catalogo;

import java.sql.*;
import java.util.ArrayList;

import clases.*;
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
			pst = con.prepareStatement("SELECT * FROM libros ORDER BY titulo");
			rs = pst.executeQuery();

			while (rs.next()) {
				Libro lib = new Libro(rs.getInt("idlibro"), rs.getString("titulo"), rs.getString("autor"));
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

	public void reservarLibro(Libro libro, Usuario usr) {

	}

	public void agregarLibro(String titulo, String autor) throws Exception {
		Connection con = Conexion.getConexion();
		PreparedStatement pst = null;
		ResultSet rs = null;
		con.setAutoCommit(false);

		try {
			pst = con.prepareStatement("INSERT INTO libros (titulo, autor)" + "VALUES (?,?)");
			pst.setString(1, titulo);
			pst.setString(2, autor);
			pst.executeUpdate();
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			if (con != null) {
				try {
					con.commit();
					con.setAutoCommit(true);
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
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}
