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

import tienda.tiendaVirtual.dao.UsuarioDao;
import tienda.tiendaVirtual.dto.Usuario;

@RestController
@RequestMapping("api/usuario")
public class UsuarioApi {

	@PostMapping()
	public Usuario guardar(@RequestBody Usuario usuario) {
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.guardar(usuario);
	}

	@GetMapping()
	public List<Usuario> listar() {
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.listar();
	}

	@PutMapping()
	public Usuario editar(@RequestBody Usuario usuario) {
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.editar(usuario);
	}

	@DeleteMapping("/{cedula}")
	public void eliminar(@PathVariable String cedula) {
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.eliminar(cedula);
	}

	@GetMapping("/{cedula}")
	public Usuario buscar(@PathVariable String cedula) {
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.buscar(cedula);
	}

}
