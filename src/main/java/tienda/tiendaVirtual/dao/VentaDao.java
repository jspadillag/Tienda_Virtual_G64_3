package tienda.tiendaVirtual.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import tienda.tiendaVirtual.dto.Venta;

public class VentaDao {

	public Venta guardar(Venta venta) {
		Conexion conexion = new Conexion();
		String sql = "INSERT INTO ventas (cedula_cliente, cedula_usuario, iva_venta, total_venta, valor_venta) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
			preparedStatement.setLong(1, venta.getCedula_cliente());
			preparedStatement.setLong(2, venta.getCedula_usuario());
			preparedStatement.setDouble(3, venta.getIva_venta());
			preparedStatement.setDouble(4, venta.getTotal_venta());
			preparedStatement.setDouble(5, venta.getValor_venta());
			
			preparedStatement.execute();
			
			preparedStatement.close();
			conexion.desconectar();			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return venta;
	}
}
