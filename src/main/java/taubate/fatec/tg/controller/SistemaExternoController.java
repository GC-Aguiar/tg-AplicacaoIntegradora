package taubate.fatec.tg.controller;

import java.util.List;
import java.util.Optional;

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
import taubate.fatec.tg.model.SistemaExterno;
import taubate.fatec.tg.service.SistemaExternoService;

@RestController
@RequestMapping("/sistemas")
@Api(tags = "Sistemas Externos", description = "Retorna dados referentes aos sistemas externos cadastrados no SIDBM.")
public class SistemaExternoController {

	@Autowired
	private SistemaExternoService service;

	@GetMapping
	@ApiOperation(value = "Listar sistemas externos", notes = "Retorna todos os sistemas externos cadastrados no SIDBM", hidden = false)
	public List<SistemaExterno> listar() {
		System.out.println("List");
		return service.buscarSistemasExternos();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar sistema externo por ID", notes = "Retorna um sistema externo dado o ID", hidden = false)
	public Optional<SistemaExterno> buscarPorId(@PathVariable("id") Integer id) {
		return service.buscarSistemaExternoPorId(id);

	}

	@GetMapping("/status/{status}")
	@ApiOperation(value = "Buscar sistemas externo por status", notes = "Retorna um sistema externo dado o status", hidden = false)
	public List<String> buscaPorRegiao(@PathVariable("status") String status) {
		return service.buscarSistemaExternoPorStatus(status);
	}

	@PostMapping
	@ApiOperation(value = "Inserir novo sistema externo", notes = "Insere um novo sistema externo no SIDBM", hidden = false)
	public void save(@RequestBody SistemaExterno sistemaExterno) {
		System.out.println("Save");
		System.out.println(sistemaExterno);
		service.gravarSistemaExterno(sistemaExterno);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir sistema externo por ID", notes = "Exclui um sistema externo do SIDBM", hidden = false)
	public void delete(@PathVariable("id") Integer id) {
		service.deletarSistemaExterno(id);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Alterar sistema externo", notes = "Altera um sistema externo dado um ID", hidden = false)
	public void update(@PathVariable("id") Integer id, @RequestBody SistemaExterno sistemaExterno) {
		System.out.println("Update");
		System.out.println(sistemaExterno);

		service.alterarSistemaExterno(sistemaExterno, id); // Recebe o sistemaExterno e o ID da URL para validar

	}
}
