package catalogo;

import java.sql.*;
import clases.Administrador;
import clases.Usuario;
import utils.Conexion;

public class CatalogoUsuarios {

	public Usuario iniciarSesion(String usr, String pass) throws Exception {
		Connection con = Conexion.getConexion();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Usuario user;
		try {
			pst = con.prepareStatement("select * from usuarios where usuario=? and contrasena=?");
			pst.setString(1, usr);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			if (rs.next()) {
				if (!rs.getBoolean("admin")) {
					user = new Usuario(usr, pass);
				} else {
					user = new Administrador(usr, pass);
				}
			} else {
				user = null;
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
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		return user;
	}
}
