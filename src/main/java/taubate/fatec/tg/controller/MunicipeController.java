package taubate.fatec.tg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import taubate.fatec.tg.model.Municipe;
import taubate.fatec.tg.service.MunicipeService;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

@RestController
@RequestMapping("/municipes")
@Api(tags = "Munícipes", description = "Retorna dados referentes aos munícipes.")
public class MunicipeController {

	@Autowired
	private MunicipeService service;

	@GetMapping
	@ApiOperation(value = "Listar munícipes", notes = "Retorna todos os munícipes cadastrados no SIDBM", hidden = false)
	public List<Municipe> buscarMunicipes() {
		System.out.println("List");
		return service.buscarMunicipes();
	}

	@GetMapping("/cpf/{cpf}")
	@ApiOperation(value = "Listar munícipe por CPF", notes = "Retorna um munícipe dado um CPF", hidden = false)
	public Municipe find(@PathVariable("cpf") String cpf) {
		return service.buscarMunicipePorCpf(cpf);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Listar munícipe por ID", notes = "Retorna um munícipe dado um ID", hidden = false)
	public Optional<Municipe> buscarPorId(@PathVariable("id") Integer id) {
		return service.buscarMunicipePorId(id);
	}

	@PostMapping
	@ApiOperation(value = "Inserir novo munícipe", notes = "Insere um novo munícipe no SIDBM", hidden = false)
	public ResponseEntity<String> save(@RequestBody Municipe municipe) {
		
		
	    // Realiza a validação do CPF
	    CPFValidator cpfValidator = new CPFValidator();
	    try {
	        cpfValidator.assertValid(municipe.getCpf());
	    } catch (InvalidStateException e) {
	        System.out.println("CPF inválido. Requisição recusada");
	        System.out.println(municipe);
	        return ResponseEntity.badRequest().body("Requisição negada: CPF inválido.");
	    }
		
		if(service.buscarMunicipePorCpf(municipe.getCpf()) != null) {
			System.out.println("Munícipe duplicado. Requisição recusada");
			System.out.println(municipe);	
			return ResponseEntity.badRequest().body("Requisição negada: CPF " + municipe.getCpf() + " já cadastrado.");			
		}else {
			System.out.println("++ Inserindo no munícipe (save) ++ ");
			System.out.println(municipe);
			service.gravarMunicipe(municipe);
			return ResponseEntity.ok("Munícipe inserido no SIDBM com sucesso.");
		}
		
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir munícipe por ID", notes = "Exclui um munícipe do SIDBM", hidden = true)
	public void delete(@PathVariable("id") Integer id) {
		service.deletarMunicipe(id);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Alterar munícipe", notes = "Altera um munícipe dado um ID", hidden = false)
	public void update(@PathVariable("id") Integer id, @RequestBody Municipe municipe) {
		System.out.println("** Alterando municipe existente (Update) ** ");
		System.out.println(municipe);

		service.alterarMunicipe(municipe, id); // Recebe o munícipe e o ID da URL para validar
	}
}
