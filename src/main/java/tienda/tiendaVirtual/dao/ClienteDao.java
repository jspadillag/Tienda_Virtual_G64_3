package tienda.tiendaVirtual.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tienda.tiendaVirtual.dto.Cliente;


public class ClienteDao {
	
	public Cliente guardar(Cliente cliente) {
		Conexion conexion = new Conexion();
		String sql = "INSERT INTO clientes (cedula_cliente, nombre_cliente, direccion_cliente, telefono_cliente, email_cliente) VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
			preparedStatement.setLong(1, cliente.getCedula_cliente());
			preparedStatement.setString(2, cliente.getNombre_cliente());
			preparedStatement.setString(3, cliente.getDireccion_cliente());
			preparedStatement.setString(4, cliente.getTelefono_cliente());
			preparedStatement.setString(5, cliente.getEmail_cliente());

			preparedStatement.execute();

			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<Cliente>();

		Conexion conexion = new Conexion();
		String sql = "SELECT cedula_cliente, nombre_cliente, direccion_cliente, telefono_cliente, email_cliente FROM clientes";

		try {
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setCedula_cliente(resultSet.getLong("cedula_cliente"));
				cliente.setNombre_cliente(resultSet.getString("nombre_cliente"));
				cliente.setDireccion_cliente(resultSet.getString("direccion_cliente"));
				cliente.setTelefono_cliente(resultSet.getString("telefono_cliente"));
				cliente.setEmail_cliente(resultSet.getString("email_cliente"));
				clientes.add(cliente);
			}

			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clientes;
	}

	public Cliente editar(Cliente cliente) {
		Conexion conexion = new Conexion();
		String sql = "UPDATE clientes SET nombre_cliente = ?, direccion_cliente = ?, telefono_cliente = ?, email_cliente = ? WHERE cedula_cliente = ?";

		try {
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
			preparedStatement.setString(1, cliente.getNombre_cliente());
			preparedStatement.setString(2, cliente.getDireccion_cliente());
			preparedStatement.setString(3, cliente.getTelefono_cliente());
			preparedStatement.setString(4, cliente.getEmail_cliente());
			preparedStatement.setLong(5, cliente.getCedula_cliente());

			preparedStatement.executeUpdate();

			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	public void eliminar(String cedula) {
		Conexion conexion = new Conexion();
		String sql = "DELETE FROM clientes WHERE cedula_cliente = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conexion.getConexion().prepareStatement(sql);
			preparedStatement.setString(1, cedula);

			preparedStatement.execute();

			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Cliente buscar(String cedula) {
		Cliente cliente = new Cliente();

		Conexion conexion = new Conexion();
		String sql = "SELECT cedula_cliente, nombre_cliente, direccion_cliente, telefono_cliente, email_cliente FROM clientes WHERE cedula_cliente = ?";

		PreparedStatement preparedSatement;
		try {
			preparedSatement = conexion.getConexion().prepareStatement(sql);
			preparedSatement.setString(1, cedula);

			ResultSet resultSet = preparedSatement.executeQuery();

			if (resultSet.next()) {
				cliente.setCedula_cliente(resultSet.getLong("cedula_cliente"));
				cliente.setNombre_cliente(resultSet.getString("nombre_cliente"));
				cliente.setDireccion_cliente(resultSet.getString("direccion_cliente"));
				cliente.setTelefono_cliente(resultSet.getString("telefono_cliente"));
				cliente.setEmail_cliente(resultSet.getString("email_cliente"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}

}
