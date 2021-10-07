package tienda.tiendaVirtual.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tienda.tiendaVirtual.dto.Producto;

public class ProductoDao {

	public Producto guardar(Producto producto) {
		Conexion conexion = new Conexion();
		String sql = "INSERT INTO productos (codigo_producto, ivacompra, nitproveedor, nombre_producto, precio_compra, precio_venta) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
			preparedStatement.setInt(1, producto.getCodigo_producto());
			preparedStatement.setDouble(2, producto.getIvacompra());
			preparedStatement.setInt(3, producto.getNitproveedor());
			preparedStatement.setString(4, producto.getNombre_producto());
			preparedStatement.setDouble(5, producto.getPrecio_compra());
			preparedStatement.setDouble(6, producto.getPrecio_venta());

			preparedStatement.execute();

			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;
	}
	
	public List<Producto> listar() {
		List<Producto> productos = new ArrayList<Producto>();

		Conexion conexion = new Conexion();
		String sql = "SELECT codigo_producto, ivacompra, nitproveedor, nombre_producto, precio_compra, precio_venta FROM productos";

		try {
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Producto producto = new Producto();
				producto.setCodigo_producto(resultSet.getInt("codigo_producto"));
				producto.setIvacompra(resultSet.getDouble("ivacompra"));
				producto.setNitproveedor(resultSet.getInt("nitproveedor"));
				producto.setNombre_producto(resultSet.getString("nombre_producto"));
				producto.setPrecio_compra(resultSet.getDouble("precio_compra"));
				producto.setPrecio_venta(resultSet.getDouble("precio_venta"));
				productos.add(producto);
			}

			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productos;
	}
	
	public Producto editar(Producto producto) {
		Conexion conexion = new Conexion();
		String sql = "UPDATE productos SET ivacompra = ?, nitproveedor = ?, nombre_producto = ?, precio_compra = ?, precio_venta = ? WHERE codigo_producto = ?";

		try {
			PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
			preparedStatement.setDouble(1, producto.getIvacompra());
			preparedStatement.setInt(2, producto.getNitproveedor());
			preparedStatement.setString(3, producto.getNombre_producto());
			preparedStatement.setDouble(4, producto.getPrecio_compra());
			preparedStatement.setDouble(5, producto.getPrecio_venta());
			preparedStatement.setInt(5, producto.getCodigo_producto());

			preparedStatement.executeUpdate();

			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return producto;
	}
	
	public void eliminar(Integer codigo) {
		Conexion conexion = new Conexion();
		String sql = "DELETE FROM productos WHERE codigo_producto = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conexion.getConexion().prepareStatement(sql);
			preparedStatement.setInt(1, codigo);

			preparedStatement.execute();

			preparedStatement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Producto buscar(Integer codigo) {
		Producto producto = new Producto();

		Conexion conexion = new Conexion();
		String sql = "SELECT codigo_producto, ivacompra, nitproveedor, nombre_producto, precio_compra, precio_venta FROM productos WHERE codigo_producto = ?";

		PreparedStatement preparedSatement;
		try {
			preparedSatement = conexion.getConexion().prepareStatement(sql);
			preparedSatement.setInt(1, codigo);

			ResultSet resultSet = preparedSatement.executeQuery();

			if (resultSet.next()) {
				producto.setCodigo_producto(resultSet.getInt("codigo_producto"));
				producto.setIvacompra(resultSet.getDouble("ivacompra"));
				producto.setNitproveedor(resultSet.getInt("nitproveedor"));
				producto.setNombre_producto(resultSet.getString("nombre_producto"));
				producto.setPrecio_compra(resultSet.getDouble("precio_compra"));
				producto.setPrecio_venta(resultSet.getDouble("precio_venta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return producto;
	}
	
	public void eliminarTodo() {
		Conexion conexion = new Conexion();
		try {
			Statement consulta = conexion.getConexion().createStatement();
			String sentencia = "delete from productos;";
			consulta.execute(sentencia);
			consulta.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar todos los productos");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar todos los productos");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}



}
