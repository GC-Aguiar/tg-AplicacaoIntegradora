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

import taubate.fatec.tg.model.PerfilUsuario;
import taubate.fatec.tg.service.PerfilUsuarioService;

@RestController
@RequestMapping("/perfisusuario")
public class PerfilUsuarioController {
	
	@Autowired
	private PerfilUsuarioService service;
	
	@GetMapping
    public List<PerfilUsuario> listar(){
    	System.out.println("List");
        return service.buscarPerfisUsuario();
    }	 
	
    @GetMapping("/{id}")
    public Optional<PerfilUsuario> buscarPorId(@PathVariable ("id") Integer id){
    	return service.buscarPerfilUsuarioPorId(id);	
    	
    }
    
    @GetMapping("/status/{status}")
    public List<String> buscaPorUf(@PathVariable ("status") String status){
    	return service.buscarPerfilUsuarioPorStatus(status);    	
    }
    
    @PostMapping
    public void save(@RequestBody PerfilUsuario perfilUsuario){
    	System.out.println("Save");
    	System.out.println(perfilUsuario);    	
        service.gravarPerfilUsuario(perfilUsuario);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.deletarPerfilUsuario(id);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody PerfilUsuario perfilUsuario){
    	System.out.println("Update");
    	System.out.println(perfilUsuario);
    	
        service.alterarPerfilUsuario(perfilUsuario, id); //Recebe o perfilUsuario e o ID da URL para validar
        
    }

}
