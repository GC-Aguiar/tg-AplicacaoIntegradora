package taubate.fatec.tg.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import taubate.fatec.tg.model.Usuario;
import taubate.fatec.tg.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
	//Alterar para service
	@Autowired
    private UsuarioRepository repository;
    @GetMapping
    public List<Usuario> list(){
    	System.out.println("List");
        return repository.findAll();
    }
    @PostMapping
    public void save(@RequestBody Usuario usuario){
    	System.out.println("Save");
    	System.out.println(usuario);
    	
        repository.save(usuario);
    }
    @PutMapping
    public void update(@RequestBody Usuario usuario){
    	System.out.println("Update");
        repository.save(usuario);
    }
    @GetMapping("/{id}")
    public Optional<Usuario> find(@PathVariable ("id") Integer id){
    	return repository.findById(id);
    }  

    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("/id") Integer id){
        repository.deleteById(id);
    }
}
