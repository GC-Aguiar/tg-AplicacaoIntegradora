package taubate.fatec.tg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taubate.fatec.tg.service.LgpdService;

@RestController
@RequestMapping("/lgpd")
public class LgpdController {
	
	@Autowired
	LgpdService service;
	
	@GetMapping
	public List<String> list(){
		return service.buscarLgpd(); 
	}
	
	@PutMapping
	public void insereExclusaoLgpd(@RequestBody String cpf) {
		service.inserirLgpd(cpf);		
	}
	


}
