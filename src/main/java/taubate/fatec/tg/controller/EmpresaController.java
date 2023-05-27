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
import taubate.fatec.tg.model.Empresa;
import taubate.fatec.tg.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
@Api(tags = "Empresas", description = "Retorna dados referentes às empresas cadastradas no SIDBM.")
public class EmpresaController {

	@Autowired
	private EmpresaService service;

	@GetMapping
	@ApiOperation(value = "Listar empresas", notes = "Retorna todas as empresas cadastradas", hidden = false)
	public List<Empresa> listar() {
		System.out.println("List");
		return service.buscarEmpresas();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Listar empresa por ID", notes = "Retorna uma empresa dado um ID", hidden = false)
	public Optional<Empresa> buscarPorId(@PathVariable("id") Integer id) {
		return service.buscarEmpresaPorId(id);

	}

	@GetMapping("/cnpj/{cnpj}")
	@ApiOperation(value = "Listar empresa por CNPJ", notes = "Retorna uma empresa dado um CNPJ", hidden = false)
	public List<String> buscaPorRegiao(@PathVariable("cnpj") String cnpj) {
		return service.buscarEmpresaPorCnpj(cnpj);
	}

	@PostMapping
	@ApiOperation(value = "Gravar empresa", notes = "Grava uma nova empresa", hidden = true)
	public void save(@RequestBody Empresa empresa) {
		System.out.println("Save");
		System.out.println(empresa);
		service.gravarEmpresa(empresa);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir empresa", notes = "Exclui uma empresa dado um ID", hidden = false)
	public void delete(@PathVariable("id") Integer id) {
		service.deletarEmpresa(id);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Alterar empresa", notes = "Altera uma empresa dado um ID", hidden = false)
	public void update(@PathVariable("id") Integer id, @RequestBody Empresa empresa) {
		System.out.println("Update");
		System.out.println(empresa);

		service.alterarEmpresa(empresa, id); // Recebe o empresa e o ID da URL para validar

	}

}
