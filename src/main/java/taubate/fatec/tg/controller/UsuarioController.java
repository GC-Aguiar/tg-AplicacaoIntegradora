package taubate.fatec.tg.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taubate.fatec.tg.model.Usuario;
import taubate.fatec.tg.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    	
	@Autowired
    private UsuarioService service;
   
	
	@GetMapping
	//@RolesAllowed("1")
    public List<Usuario> list(){
    	System.out.println("List");
        return service.buscarUsuarios();
    }
    
	@RolesAllowed("1")
	@PostMapping
    public void save(@RequestBody Usuario usuario){
    	System.out.println("Save");
    	System.out.println(usuario);
    	
       service.gravarUsuario(usuario);
    }
	@RolesAllowed("1")
    @PutMapping
    public void update(@RequestBody Usuario usuario, @PathVariable("/id") Integer id){
    	System.out.println("Update");
        service.alterarUsuario(usuario, id);
    }
	//@RolesAllowed({"1", "2", "3", "admin"})
    @GetMapping("/{id}")
    public Optional<Usuario> find(@PathVariable ("id") Integer id){
    	return service.buscarUsuarioPorId(id);
    }  

	@RolesAllowed("1")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("/id") Integer id){
        service.deletarUsuario(id);
    }
}
