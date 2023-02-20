package taubate.fatec.tg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taubate.fatec.tg.model.SistemaExterno;
import taubate.fatec.tg.service.SistemaExternoService;

@RestController
@RequestMapping("/sistemasexternos")
public class SistemaExternoController {
	
	@Autowired
	private SistemaExternoService sistemaExterno;
	
	@GetMapping
    public List<SistemaExterno> listar(){
    	System.out.println("List");
        return sistemaExterno.buscarSistemasExternos();
    }
}
