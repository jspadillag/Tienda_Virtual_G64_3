package tienda.tiendaVirtual.API;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tienda.tiendaVirtual.dao.ProductoDao;
import tienda.tiendaVirtual.dto.Producto;


@RestController
@RequestMapping("api/producto")
public class ProductoApi {

	@PostMapping()
	public Producto guardar(@ModelAttribute Producto producto) {
		ProductoDao productoDao = new ProductoDao();
		return productoDao.guardar(producto);
	}
	
	@GetMapping()
	public List<Producto> listar() {
		ProductoDao productoDao = new ProductoDao();
		return productoDao.listar();
	}
	
	@PutMapping()
	public Producto editar(@RequestBody Producto producto) {
		ProductoDao productoDao = new ProductoDao();
		return productoDao.editar(producto);
	}

	@DeleteMapping("/{codigo}")
	public void eliminar(@PathVariable Integer codigo) {
		ProductoDao productoDao = new ProductoDao();
		productoDao.eliminar(codigo);
	}

	@GetMapping("/{codigo}")
	public Producto buscar(@PathVariable Integer codigo) {
		ProductoDao productoDao = new ProductoDao();
		return productoDao.buscar(codigo);
	}

	@DeleteMapping()
	public void eliminarTodo() {
		ProductoDao Dao = new ProductoDao();
		Dao.eliminarTodo();
	}


}
