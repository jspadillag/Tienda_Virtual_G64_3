package tienda.tiendaVirtual.API;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tienda.tiendaVirtual.dao.ProveedoresDao;
import tienda.tiendaVirtual.dto.Proveedores;


@RestController
@RequestMapping("api/proveedores")
public class ProveedoresApi {

	@PostMapping()
	public Proveedores guardar(@RequestBody Proveedores proveedor) {
		ProveedoresDao proveedoresDao = new ProveedoresDao();
		return proveedoresDao.guardar(proveedor);
	}

	@GetMapping()
	public List<Proveedores> listar() {
		ProveedoresDao proveedoresDao = new ProveedoresDao();
		return proveedoresDao.listar();
	}

	@PutMapping()
	public Proveedores editar(@RequestBody Proveedores proveedores) {
		ProveedoresDao proveedoresDao = new ProveedoresDao();
		return proveedoresDao.editar(proveedores);
	}

	@DeleteMapping("/{nit}")
	public void eliminar(@PathVariable String nit) {
		ProveedoresDao proveedoresDao = new ProveedoresDao();
		proveedoresDao.eliminarProveedores(nit);
	}

	@GetMapping("/{nit}")
	public Proveedores buscar(@PathVariable String nit) {
		ProveedoresDao proveedoresDao = new ProveedoresDao();
		return proveedoresDao.buscar(nit);
	}

}
