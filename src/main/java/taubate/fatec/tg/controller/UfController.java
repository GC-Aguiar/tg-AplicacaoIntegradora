package taubate.fatec.tg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taubate.fatec.tg.model.Uf;
import taubate.fatec.tg.service.UfService;

@RestController
@RequestMapping("/ufs")
public class UfController {
	
	@Autowired
	private UfService uf;
	
	@GetMapping
    public List<Uf> listar(){
    	System.out.println("List");
        return uf.buscarUfs();
    }

}
