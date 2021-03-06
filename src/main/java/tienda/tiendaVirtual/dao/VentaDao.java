package tienda.tiendaVirtual.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tienda.tiendaVirtual.dto.ListarVenta;
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

	public List<Venta> listar() {
		List<Venta> ventas = new ArrayList<Venta>();

		Conexion conexion = new Conexion();
		String sql = "SELECT codigo_venta, cedula_cliente, cedula_usuario, iva_venta, total_venta, valor_venta FROM ventas";

		try {
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
				

			while (resultSet.next()) {
			
				Venta venta = new Venta();
				venta.setCodigo_venta(resultSet.getInt("Codigo_venta"));
				venta.setCedula_cliente(resultSet.getLong("Cedula_cliente"));
				venta.setCedula_usuario(resultSet.getLong("Cedula_usuario"));
				venta.setIva_venta(resultSet.getDouble("Iva_venta"));
				venta.setTotal_venta(resultSet.getDouble("Total_venta"));
				venta.setValor_venta(resultSet.getDouble("Valor_venta"));
				ventas.add(venta);
			}

			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ventas;
	}

	public Venta editar(Venta ventas) {
		Conexion conexion = new Conexion();
		String sql = "UPDATE ventas SET cedula_cliente = ?, cedula_usuario 	= ?, iva_venta = ?, total_venta = ?, valor_venta = ?  WHERE codigo_venta = ?";

		try {
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
			preparedStatement.setLong(1, ventas.getCedula_cliente());
			preparedStatement.setLong(2, ventas.getCedula_usuario());
			preparedStatement.setDouble(3, ventas.getIva_venta());
			preparedStatement.setDouble(4, ventas.getTotal_venta());
			preparedStatement.setDouble(5, ventas.getValor_venta());
			preparedStatement.setInt(6, ventas.getCodigo_venta());
			
			preparedStatement.executeUpdate();

			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ventas;
	}

	public void eliminarVenta(String codigo_venta) {
		Conexion conexion = new Conexion();
		String sql = "DELETE FROM ventas WHERE codigo_venta = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conexion.getConexion().prepareStatement(sql);
			preparedStatement.setString(1, codigo_venta);
			preparedStatement.execute();
			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Venta buscar(String ventas) {
		Venta venta = new Venta();

		Conexion conexion = new Conexion();
		String sql = "SELECT codigo_venta, cedula_cliente, cedula_usuario, iva_venta, total_venta, valor_venta FROM ventas WHERE codigo_venta = ?";

		PreparedStatement preparedSatement;
		try {
			preparedSatement = conexion.getConexion().prepareStatement(sql);
			preparedSatement.setString(1, ventas);

			ResultSet resultSet = preparedSatement.executeQuery();

			if (resultSet.next()) {
				venta.setCodigo_venta(resultSet.getInt("Codigo_venta"));
				venta.setCedula_cliente(resultSet.getLong("Cedula_cliente"));
				venta.setCedula_usuario(resultSet.getLong("Cedula_usuario"));
				venta.setIva_venta(resultSet.getDouble("Iva_venta"));
				venta.setTotal_venta(resultSet.getDouble("Total_venta"));
				venta.setValor_venta(resultSet.getDouble("Valor_venta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return venta;
	}

	public List<ListarVenta> listarVenta() {
		List<ListarVenta> ventas = new ArrayList<ListarVenta>();
		Conexion conexion = new Conexion();
		String sql = "SELECT ventas.cedula_cliente, clientes.nombre_cliente, ventas.total_venta FROM ventas JOIN clientes ON ventas.cedula_cliente=clientes.cedula_cliente";
		try {
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {			
				ListarVenta lventa = new ListarVenta();
				lventa.setCedula_cliente(resultSet.getLong("Cedula_cliente"));
				lventa.setNombre_cliente(resultSet.getString("Nombre_Cliente"));
				lventa.setTotal_venta(resultSet.getDouble("Total_venta"));
				ventas.add(lventa);
			}
			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ventas;

	}
}

