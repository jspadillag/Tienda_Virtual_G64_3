package tienda.tiendaVirtual.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tienda.tiendaVirtual.dto.Proveedores;



	public class ProveedoresDao {

		public Proveedores guardar(Proveedores proveedores) {
			Conexion conexion = new Conexion();
			String sql = "INSERT INTO proveedores (nitproveedor,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor) VALUES (?, ?, ?, ?, ?)";

			try {
				PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
				preparedStatement.setInt(1, proveedores.getNitproveedor());
				preparedStatement.setString(2, proveedores.getCiudad_proveedor());
				preparedStatement.setString(3, proveedores.getDireccion_proveedor());
				preparedStatement.setString(4, proveedores.getNombre_proveedor());
				preparedStatement.setString(5, proveedores.getTelefono_proveedor());

				preparedStatement.execute();

				preparedStatement.close();
				conexion.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return proveedores;
		}

		public List<Proveedores> listar() {
			List<Proveedores> proveedores = new ArrayList<Proveedores>();

			Conexion conexion = new Conexion();
			String sql = "SELECT nitproveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor FROM proveedores";

			try {
				PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Proveedores proveedor = new Proveedores();
					proveedor.setNitproveedor(resultSet.getInt("Nitproveedor"));
					proveedor.setCiudad_proveedor(resultSet.getString("Ciudad_proveedor"));
					proveedor.setDireccion_proveedor(resultSet.getString("Direccion_proveedor"));
					proveedor.setNombre_proveedor(resultSet.getString("Nombre_proveedor"));
					proveedor.setTelefono_proveedor(resultSet.getString("Telefono_proveedor"));
					proveedores.add(proveedor);
				}

				preparedStatement.close();
				conexion.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return proveedores;
		}

		public Proveedores editar(Proveedores proveedores) {
			Conexion conexion = new Conexion();
			String sql = "UPDATE proveedores SET ciudad_proveedor = ?, direccion_proveedor = ?, nombre_proveedor = ?, telefono_proveedor = ?  WHERE nitproveedor = ?";

			try {
				PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
				preparedStatement.setString(1, proveedores.getCiudad_proveedor());
				preparedStatement.setString(2, proveedores.getDireccion_proveedor());
				preparedStatement.setString(3, proveedores.getNombre_proveedor());
				preparedStatement.setString(4, proveedores.getTelefono_proveedor());
				preparedStatement.setInt(5, proveedores.getNitproveedor());
				
				preparedStatement.executeUpdate();

				preparedStatement.close();
				conexion.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return proveedores;
		}

		public void eliminarProveedores(String nitproveedor) {
			Conexion conexion = new Conexion();
			String sql = "DELETE FROM proveedores WHERE nitproveedor = ?";
			PreparedStatement preparedStatement;
			try {
				preparedStatement = conexion.getConexion().prepareStatement(sql);
				preparedStatement.setString(1, nitproveedor);
				preparedStatement.execute();
				preparedStatement.close();
				conexion.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public Proveedores buscar(String proveedores) {
			Proveedores proveedor = new Proveedores();

			Conexion conexion = new Conexion();
			String sql = "SELECT nitproveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor FROM proveedores WHERE nitproveedor = ?";

			PreparedStatement preparedSatement;
			try {
				preparedSatement = conexion.getConexion().prepareStatement(sql);
				preparedSatement.setString(1, proveedores);

				ResultSet resultSet = preparedSatement.executeQuery();

				if (resultSet.next()) {
					proveedor.setNitproveedor(resultSet.getInt("Nitproveedor"));
					proveedor.setCiudad_proveedor(resultSet.getString("Ciudad_proveedor"));
					proveedor.setDireccion_proveedor(resultSet.getString("Direccion_proveedor"));
					proveedor.setNombre_proveedor(resultSet.getString("Nombre_proveedor"));
					proveedor.setTelefono_proveedor(resultSet.getString("Telefono_proveedor"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return proveedor;
		}

	}

