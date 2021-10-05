package tienda.tiendaVirtual.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	/*private static final String DATABASE = "grupo64_equipo3";
	private static final String USER = "admin";
	private static final String PASSWORD = "Admin123$";
	private static final String URL = "jdbc:mariadb://camiloc2.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/" + DATABASE;
*/
	static String DATABASE = "tienda";
	static String USER = "root";
	static String PASSWORD = "root";
	static String URL = "jdbc:mysql://localhost:3306/"+DATABASE;
	private Connection conexion = null;

	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conexion = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Connection getConexion() {
		return this.conexion;
	}

	public void desconectar() {
		try {
			this.conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexion = null;
		}
	}

}
