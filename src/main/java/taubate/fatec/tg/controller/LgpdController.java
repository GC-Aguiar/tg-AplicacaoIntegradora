package taubate.fatec.tg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import taubate.fatec.tg.service.LgpdService;

@RestController
@RequestMapping("/lgpd")
@Api(tags = "LGPD", description = "Retorna os munícipes que solicitaram exclusão de dados via LGPD")
public class LgpdController {

	@Autowired
	LgpdService service;

	@GetMapping
	@ApiOperation(value = "Listar solicitações de exclusão de dados", notes = "Retorna todos os munícipes que solicitaram excluisão de dados via LGPD", hidden = false)
	public List<String> list() {
		return service.buscarLgpd();
	}

	@PutMapping
	@ApiOperation(value = "Inserir uma solicitação de exclusão de dados", notes = "Insere um munícipe na lista de exclusão de dados", hidden = false)
	public void insereExclusaoLgpd(@RequestBody String cpf) {
		service.inserirLgpd(cpf);
	}

}
