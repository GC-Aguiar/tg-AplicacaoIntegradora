package taubate.fatec.tg.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import taubate.fatec.tg.model.Usuario;
import taubate.fatec.tg.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@Api(tags = "Usuários", description = "Retorna dados referentes aos usuários cadastrados no SIDBM.")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	// @RolesAllowed("1")
	@ApiOperation(value = "Listar usuários", notes = "Retorna todos os usuários cadastrados no SIDBM", hidden = false)
	public List<Usuario> list() {
		System.out.println("List");
		return service.buscarUsuarios();
	}

	@RolesAllowed("1")
	@PostMapping
	@ApiOperation(value = "Inserir novo usuário", notes = "Insere um novo usuário no SIDBM", hidden = false)
	public void save(@RequestBody Usuario usuario) {
		System.out.println("Save");
		System.out.println(usuario);

		service.gravarUsuario(usuario);
	}

	@RolesAllowed("1")
	@PutMapping
	@ApiOperation(value = "Alterar usuário", notes = "Altera um usuário dado um ID", hidden = false)
	public void update(@RequestBody Usuario usuario, @PathVariable("/id") Integer id) {
		System.out.println("Update");
		service.alterarUsuario(usuario, id);
	}

	// @RolesAllowed({"1", "2", "3", "admin"})
	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar usuário por ID", notes = "Retorna um usuário dado o ID", hidden = false)
	public Optional<Usuario> find(@PathVariable("id") Integer id) {
		return service.buscarUsuarioPorId(id);
	}

	@RolesAllowed("1")
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir usuário por ID", notes = "Exclui um usuário do SIDBM dado o ID", hidden = false)
	public void delete(@PathVariable("/id") Integer id) {
		service.deletarUsuario(id);
	}
}
