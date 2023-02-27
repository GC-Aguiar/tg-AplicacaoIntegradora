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

import taubate.fatec.tg.model.Cidade;
import taubate.fatec.tg.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeService service ;
		
	@GetMapping
    public List<Cidade> listar(){
    	System.out.println("List");
        return service.buscarCidades();
    }
	
    @GetMapping("/{id}")
    public Optional<Cidade> buscarPorId(@PathVariable ("id") Integer id){
    	return service.buscarCidadePorId(id);	
    	
    }
    
    @GetMapping("/uf/{uf}")
    public List<String> buscaPorUf(@PathVariable ("uf") Integer uf){
    	return service.buscarCidadePorCodigoUf(uf);    	
    }
    
    @PostMapping
    public void save(@RequestBody Cidade cidade){
    	System.out.println("Save");
    	System.out.println(cidade);    	
        service.gravarCidade(cidade);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.deletarCidade(id);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Cidade cidade){
    	System.out.println("Update");
    	System.out.println(cidade);
    	
        service.alterarCidade(cidade, id); //Recebe o cidade e o ID da URL para validar
        
    }

}
