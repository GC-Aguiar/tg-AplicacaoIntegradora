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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import taubate.fatec.tg.model.Bairro;
import taubate.fatec.tg.service.BairroService;

@RestController
@RequestMapping("/bairros")
@Api(tags = "Bairros", description = "Retorna dados referente aos bairros do município de Taubaté.")
public class BairroController {
	
	@Autowired
	private BairroService service;
		
	@GetMapping
	//@RolesAllowed("ROLE_ADMIN") // Perfis que podem acessar o método  @RolesAllowed({"USER", "ADMIN"})
	@ApiOperation(value = "Listar bairros", notes = "Retorna todas os bairros do município de Taubaté", hidden = false)
    public List<Bairro> listar(){
    	System.out.println("List");
        return service.buscarBairros();
    }
	
    @GetMapping("/{id}")
    @ApiOperation(value = "Listar bairro por ID", notes = "Retorna todos os bairros dado um ID", hidden = false)
    public Optional<Bairro> buscarPorId(@PathVariable ("id") Integer id){
    	return service.buscarBairroPorId(id);    	
    }
    
    @GetMapping("/regiao/{regiao}")
    @ApiOperation(value = "Listar bairro por região", notes = "Retorna todos os bairros dado uma região", hidden = false)
    public List<String> buscaPorRegiao(@PathVariable ("regiao") String regiao){
    	return service.buscarBairroPorRegiao(regiao);    	
    }
    
    @PostMapping
    @ApiOperation(value = "Gravar bairro", notes = "Grava um novo bairro", hidden = true)
    public void save(@RequestBody Bairro bairro){
    	System.out.println("Save");
    	System.out.println(bairro);    	
        service.gravarBairro(bairro);
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Excluir bairro", notes = "Exclui um bairro dado um ID", hidden = true)
    public void delete(@PathVariable("id") Integer id){
        service.deletarBairro(id);
    }
    
    @PutMapping("/{id}")
    @ApiOperation(value = "Alterar bairro", notes = "Altera um bairro dado um ID", hidden = true)
    public void update(@PathVariable("id") Integer id, @RequestBody Bairro bairro){
    	System.out.println("Update");
    	System.out.println(bairro);
    	
        service.alterarBairro(bairro, id); //Recebe o bairro e o ID da URL para validar        
    }
}
