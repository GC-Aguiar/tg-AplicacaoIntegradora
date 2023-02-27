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

import taubate.fatec.tg.model.SistemaExterno;
import taubate.fatec.tg.service.SistemaExternoService;

@RestController
@RequestMapping("/sistemas")
public class SistemaExternoController {
	
	@Autowired
	private SistemaExternoService service;
	
	@GetMapping
    public List<SistemaExterno> listar(){
    	System.out.println("List");
        return service.buscarSistemasExternos();
    }
    @GetMapping("/{id}")
    public Optional<SistemaExterno> buscarPorId(@PathVariable ("id") Integer id){
    	return service.buscarSistemaExternoPorId(id);	
    	
    }
    
    @GetMapping("/status/{status}")
    public List<String> buscaPorRegiao(@PathVariable ("status") String status){
    	return service.buscarSistemaExternoPorStatus(status);    	
    }
    
    @PostMapping
    public void save(@RequestBody SistemaExterno sistemaExterno){
    	System.out.println("Save");
    	System.out.println(sistemaExterno);    	
        service.gravarSistemaExterno(sistemaExterno);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.deletarSistemaExterno(id);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody SistemaExterno sistemaExterno){
    	System.out.println("Update");
    	System.out.println(sistemaExterno);
    	
        service.alterarSistemaExterno(sistemaExterno, id); //Recebe o sistemaExterno e o ID da URL para validar
        
    }
}
