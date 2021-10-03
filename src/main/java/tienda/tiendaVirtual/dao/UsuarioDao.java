package tienda.tiendaVirtual.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tienda.tiendaVirtual.dto.Usuario;


	public class UsuarioDao {

		public Usuario guardar(Usuario usuario) {
			Conexion conexion = new Conexion();
			String sql = "INSERT INTO usuarios (cedula_usuario, nombre_usuario, usuario, password, email_usuario) VALUES (?, ?, ?, ?, ?)";

			try {
				PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
				preparedStatement.setLong(1, usuario.getCedula_usuario());
				preparedStatement.setString(2, usuario.getNombre_usuario());
				preparedStatement.setString(3, usuario.getUsuario());
				preparedStatement.setString(4, usuario.getPassword());
				preparedStatement.setString(5, usuario.getEmail_usuario());

				preparedStatement.execute();

				preparedStatement.close();
				conexion.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return usuario;
		}

		public List<Usuario> listar() {
			List<Usuario> usuarios = new ArrayList<Usuario>();

			Conexion conexion = new Conexion();
			String sql = "SELECT cedula_usuario, nombre_usuario, usuario, password, email_usuario FROM usuarios";

			try {
				PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Usuario usuario = new Usuario();
					usuario.setCedula_usuario(resultSet.getLong("cedula_usuario"));
					usuario.setNombre_usuario(resultSet.getString("nombre_usuario"));
					usuario.setUsuario(resultSet.getString("usuario"));
					usuario.setPassword(resultSet.getString("password"));
					usuario.setEmail_usuario(resultSet.getString("email_usuario"));
					usuarios.add(usuario);
				}

				preparedStatement.close();
				conexion.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return usuarios;
		}

		public Usuario editar(Usuario usuario) {
			Conexion conexion = new Conexion();
			String sql = "UPDATE usuarios SET nombre_usuario = ?, usuario = ?, password = ?, email_usuario = ? WHERE cedula_usuario = ?";

			try {
				PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
				preparedStatement.setString(1, usuario.getNombre_usuario());
				preparedStatement.setString(2, usuario.getUsuario());
				preparedStatement.setString(3, usuario.getPassword());
				preparedStatement.setString(4, usuario.getEmail_usuario());
				preparedStatement.setLong(5, usuario.getCedula_usuario());

				preparedStatement.executeUpdate();

				preparedStatement.close();
				conexion.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return usuario;
		}

		public void eliminar(String cedula) {
			Conexion conexion = new Conexion();
			String sql = "DELETE FROM usuarios WHERE cedula_usuario = ?";

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

		public Usuario buscar(String cedula) {
			Usuario usuario = new Usuario();

			Conexion conexion = new Conexion();
			String sql = "SELECT cedula_usuario, nombre_usuario, usuario, password, email_usuario FROM usuarios WHERE cedula_usuario = ?";

			PreparedStatement preparedSatement;
			try {
				preparedSatement = conexion.getConexion().prepareStatement(sql);
				preparedSatement.setString(1, cedula);

				ResultSet resultSet = preparedSatement.executeQuery();

				if (resultSet.next()) {
					usuario.setCedula_usuario(resultSet.getLong("cedula_usuario"));
					usuario.setNombre_usuario(resultSet.getString("nombre_usuario"));
					usuario.setUsuario(resultSet.getString("usuario"));
					usuario.setPassword(resultSet.getString("password"));
					usuario.setEmail_usuario(resultSet.getString("email_usuario"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return usuario;
		}

	}

