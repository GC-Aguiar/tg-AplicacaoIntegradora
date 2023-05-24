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

import taubate.fatec.tg.model.Municipe;
import taubate.fatec.tg.service.MunicipeService;

@RestController
@RequestMapping("/municipes")
public class MunicipeController {
	
    @Autowired
    private MunicipeService service; // mudar para service || controller > service > repository
    
    @GetMapping
    public List<Municipe> buscarMunicipes(){
    	System.out.println("List");
        return service.buscarMunicipes();
    }

    @GetMapping("/cpf/{cpf}")
    public Municipe find(@PathVariable ("cpf") String cpf){
    	return service.buscarMunicipePorCpf(cpf);   	
    	
    }
    
    @GetMapping("/{id}")
    public Optional<Municipe> buscarPorId(@PathVariable ("id") Integer id){
    	return service.buscarMunicipePorId(id);	
    	
    }    
     
    @PostMapping
    public void save(@RequestBody Municipe municipe){
    	System.out.println("Save");
    	System.out.println(municipe);    	
        service.gravarMunicipe(municipe);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.deletarMunicipe(id);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Municipe municipe){
    	System.out.println("-- Update --");
    	System.out.println(municipe);
    	
        service.alterarMunicipe(municipe, id); //Recebe o bairro e o ID da URL para validar
        
    }
}
