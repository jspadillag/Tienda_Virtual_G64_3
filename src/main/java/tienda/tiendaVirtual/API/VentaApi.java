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

import tienda.tiendaVirtual.dao.VentaDao;
import tienda.tiendaVirtual.dto.Venta;

@RestController
@RequestMapping("api/venta")
public class VentaApi {

	@PostMapping()
	public Venta guardar(@RequestBody Venta venta) {
		VentaDao ventaDao = new VentaDao();
		return ventaDao.guardar(venta);
	}

	@GetMapping()
	public List<Venta> listar() {
		VentaDao ventaDao = new VentaDao();
		return ventaDao.listar();
	}

	@PutMapping()
	public Venta editar(@RequestBody Venta ventas) {
		VentaDao ventaDao = new VentaDao();
		return ventaDao.editar(ventas);
	}

	@DeleteMapping("/{codigo_venta}")
	public void eliminar(@PathVariable String codigo_venta) {
		VentaDao ventaDao = new VentaDao();
		ventaDao.eliminarVenta(codigo_venta);
	}

	@GetMapping("/{codigo_venta}")
	public Venta buscar(@PathVariable String codigo_venta) {
		VentaDao ventaDao = new VentaDao();
		return ventaDao.buscar(codigo_venta);
	}

}
