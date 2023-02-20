package taubate.fatec.tg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taubate.fatec.tg.model.PerfilUsuario;
import taubate.fatec.tg.service.PerfilUsuarioService;

@RestController
@RequestMapping("/perfisusuario")
public class PerfilUsuarioController {
	
	@Autowired
	private PerfilUsuarioService perfilUsuario;
	
	@GetMapping
    public List<PerfilUsuario> listar(){
    	System.out.println("List");
        return perfilUsuario.buscarPerfisUsuario();
    }	 

}
