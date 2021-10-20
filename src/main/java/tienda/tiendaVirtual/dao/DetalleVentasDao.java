package tienda.tiendaVirtual.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tienda.tiendaVirtual.dto.DetalleVentas;



public class DetalleVentasDao {

	public DetalleVentas guardar(DetalleVentas detalleventas) {
		Conexion conexion = new Conexion();
		String sql = "INSERT INTO detalle_ventas (codigo_detalle_venta, cantidad_producto, codigo_producto, codigo_venta, valor_total, valor_venta, valoriva ) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
			preparedStatement.setInt(1, detalleventas.getCodigo_detalle_venta());
			preparedStatement.setInt(2, detalleventas.getCantidad_producto());
			preparedStatement.setInt(3, detalleventas.getCodigo_producto());
			preparedStatement.setInt(4, detalleventas.getCodigo_venta());
			preparedStatement.setDouble(5, detalleventas.getValor_total());
			preparedStatement.setDouble(6, detalleventas.getValor_venta());
			preparedStatement.setDouble(7, detalleventas.getValoriva());

			preparedStatement.execute();
			
			preparedStatement.close();
			conexion.desconectar();			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return detalleventas;
	}

	public List<DetalleVentas> listar() {
		List<DetalleVentas> detalleventas = new ArrayList<DetalleVentas>();

		Conexion conexion = new Conexion();
		String sql = "SELECT codigo_detalle_venta, cantidad_producto, codigo_producto, codigo_venta, valor_total, valor_venta, valoriva FROM detalle_ventas";
		
		
		try {
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
			
				DetalleVentas detalleventa = new DetalleVentas();
				detalleventa.setCodigo_detalle_venta(resultSet.getInt("Codigo_detalle_venta"));
				detalleventa.setCantidad_producto(resultSet.getInt("Cantidad_producto"));
				detalleventa.setCodigo_producto(resultSet.getInt("Codigo_producto"));
				detalleventa.setCodigo_venta(resultSet.getInt("Codigo_venta"));
				detalleventa.setValor_total(resultSet.getDouble("Valor_total"));
				detalleventa.setValor_venta(resultSet.getDouble("Valor_venta"));
				detalleventa.setValoriva(resultSet.getDouble("Valoriva"));
				detalleventas.add(detalleventa);
			}

			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return detalleventas;
	}

	public DetalleVentas editar(DetalleVentas detalleventas) {
		Conexion conexion = new Conexion();
		String sql = "UPDATE detalle_ventas SET cantidad_producto =?, codigo_producto =?, codigo_venta =?, valor_total =?, valor_venta =?, valoriva =?  WHERE codigo_detalle_venta	=?";

		try {
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
			preparedStatement.setInt(1, detalleventas.getCantidad_producto());
			preparedStatement.setInt(2, detalleventas.getCodigo_producto());
			preparedStatement.setInt(3, detalleventas.getCodigo_venta());
			preparedStatement.setDouble(4, detalleventas.getValor_total());
			preparedStatement.setDouble(5, detalleventas.getValor_venta());
			preparedStatement.setDouble(6, detalleventas.getValoriva());
			preparedStatement.setInt(7, detalleventas.getCodigo_venta());
			
			preparedStatement.executeUpdate();

			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return detalleventas;
	}

	public void eliminarDetalleVentas(String codigo_detalle_venta) {
		Conexion conexion = new Conexion();
		String sql = "DELETE FROM detalle_ventas WHERE codigo_detalle_venta = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conexion.getConexion().prepareStatement(sql);
			preparedStatement.setString(1, codigo_detalle_venta);
			preparedStatement.execute();
			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public DetalleVentas buscar(String detalleventa) {
		DetalleVentas detalleventas = new DetalleVentas();

		Conexion conexion = new Conexion();
		String sql = "SELECT cantidad_producto, codigo_producto, codigo_venta, valor_total, valor_venta, valoriva FROM detalle_ventas WHERE codigo_detalle_venta = ?";
		
		PreparedStatement preparedSatement;
		try {
			preparedSatement = conexion.getConexion().prepareStatement(sql);
			preparedSatement.setString(1, detalleventa);

			ResultSet resultSet = preparedSatement.executeQuery();
					

			if (resultSet.next()) {
				
				detalleventas.setCodigo_detalle_venta(resultSet.getInt("Codigo_detalle_venta"));
				detalleventas.setCantidad_producto(resultSet.getInt("Cantidad_producto"));
				detalleventas.setCodigo_producto(resultSet.getInt("Codigo_producto"));
				detalleventas.setCodigo_venta(resultSet.getInt("Codigo_venta"));
				detalleventas.setValor_total(resultSet.getDouble("Valor_total"));
				detalleventas.setValor_venta(resultSet.getDouble("Valor_venta"));
				detalleventas.setValoriva(resultSet.getDouble("Valoriva"));
				
							}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return detalleventas;
	}

}

