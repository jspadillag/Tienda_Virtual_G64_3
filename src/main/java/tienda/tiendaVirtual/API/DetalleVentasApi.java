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

import tienda.tiendaVirtual.dao.DetalleVentasDao;
import tienda.tiendaVirtual.dto.DetalleVentas;


@RestController
@RequestMapping("api/detalleventas")
public class DetalleVentasApi {

	@PostMapping()
	public DetalleVentas guardar(@RequestBody DetalleVentas detalleventas) {
		DetalleVentasDao detalleventasDao = new DetalleVentasDao();
		return detalleventasDao.guardar(detalleventas);
	}

	@GetMapping()
	public List<DetalleVentas> listar() {
		DetalleVentasDao detalleventasDao = new DetalleVentasDao();
		return detalleventasDao.listar();
	}

	@PutMapping()
	public DetalleVentas editar(@RequestBody DetalleVentas detalleventas) {
		DetalleVentasDao detalleventasDao = new DetalleVentasDao();
		return detalleventasDao.editar(detalleventas);
	}

	@DeleteMapping("/{codigo_detalle_venta}")
	public void eliminar(@PathVariable String codigo_detalle_venta) {
		DetalleVentasDao detalleventasDao = new DetalleVentasDao();
		detalleventasDao.eliminarDetalleVentas(codigo_detalle_venta);
	}

	@GetMapping("/{codigo_detalle_venta}")
	public DetalleVentas buscar(@PathVariable String codigo_detalle_venta) {
		DetalleVentasDao detalleventasDao = new DetalleVentasDao();
		return detalleventasDao.buscar(codigo_detalle_venta);
	}

}
