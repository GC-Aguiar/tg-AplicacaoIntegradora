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

import taubate.fatec.tg.model.Uf;
import taubate.fatec.tg.service.UfService;

@RestController
@RequestMapping("/ufs")
public class UfController {
	
	@Autowired
	private UfService service;
	
	@GetMapping
    public List<Uf> listar(){
    	System.out.println("List");
        return service.buscarUfs();
    }
	
	@GetMapping("/{id}")
    public Optional<Uf> buscarPorId(@PathVariable ("id") Integer id){
    	return service.buscarUfPorId(id);	
    	
    }
    
    @GetMapping("/regiao/{regiao}")
    public List<String> buscaPorRegiao(@PathVariable ("regiao") String regiao){
    	return service.buscarUfPorRegiao(regiao);    	
    }
    
    @PostMapping
    public void save(@RequestBody Uf uf){
    	System.out.println("Save");
    	System.out.println(uf);    	
        service.gravarUf(uf);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.deletarUf(id);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Uf uf){
    	System.out.println("Update");
    	System.out.println(uf);
    	
        service.alterarUf(uf, id); //Recebe o bairro e o ID da URL para validar
        
    }

}
