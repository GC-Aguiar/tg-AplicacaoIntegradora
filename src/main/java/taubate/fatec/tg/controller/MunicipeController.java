package taubate.fatec.tg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taubate.fatec.tg.model.Municipe;

import taubate.fatec.tg.repository.MunicipeRepository;

@RestController
@RequestMapping("/municipes")
public class MunicipeController {
	
    @Autowired
    private MunicipeRepository repository; // mudar para service || controller > service > repository
    @GetMapping
    public List<Municipe> list(){
    	System.out.println("List");
        return repository.findAll();
    }
    /*@GetMapping("/{id}")
    public Optional<Municipe> find(@PathVariable ("id") Integer id){
    	return repository.findById(id);
    }*/
    @GetMapping("/{cpf}")
    public Municipe find(@PathVariable ("cpf") String cpf){
    	return repository.findByCpf(cpf);   	
    	
    }



}
