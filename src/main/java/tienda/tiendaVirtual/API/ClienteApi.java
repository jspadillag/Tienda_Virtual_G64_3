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

import tienda.tiendaVirtual.dao.ClienteDao;

import tienda.tiendaVirtual.dto.Cliente;


@RestController
@RequestMapping("api/cliente")

public class ClienteApi {
	@PostMapping()
	public Cliente guardar(@RequestBody Cliente cliente) {
		ClienteDao clienteDao = new ClienteDao();
		return clienteDao.guardar(cliente);
	}

	@GetMapping()
	public List<Cliente> listar() {
		ClienteDao clienteDao = new ClienteDao();
		return clienteDao.listar();
	}

	@PutMapping()
	public Cliente editar(@RequestBody Cliente cliente) {
		ClienteDao clienteDao = new ClienteDao();
		return clienteDao.editar(cliente);
	}

	@DeleteMapping("/{cedula}")
	public void eliminar(@PathVariable String cedula) {
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.eliminar(cedula);
	}

	@GetMapping("/{cedula}")
	public Cliente buscar(@PathVariable String cedula) {
		ClienteDao clienteDao = new ClienteDao();
		return clienteDao.buscar(cedula);
	}

}
