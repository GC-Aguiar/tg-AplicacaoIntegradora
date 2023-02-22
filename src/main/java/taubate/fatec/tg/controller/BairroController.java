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

import taubate.fatec.tg.model.Bairro;
import taubate.fatec.tg.service.BairroService;

@RestController
@RequestMapping("/bairros")
public class BairroController {
	
	@Autowired
	private BairroService service;
		
	@GetMapping
    public List<Bairro> listar(){
    	System.out.println("List");
        return service.buscarBairros();
    }
	
    @GetMapping("/{id}")
    public Optional<Bairro> buscarPorId(@PathVariable ("id") Integer id){
    	return service.buscarBairroPorId(id);	
    	
    }
    
    @GetMapping("/regiao/{regiao}")
    public List<String> buscaPorRegiao(@PathVariable ("regiao") String regiao){
    	return service.buscarBairroPorRegiao(regiao);    	
    }
    
    @PostMapping
    public void save(@RequestBody Bairro bairro){
    	System.out.println("Save");
    	System.out.println(bairro);    	
        service.gravarBairro(bairro);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.deletarBairro(id);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Bairro bairro){
    	System.out.println("Update");
    	System.out.println(bairro);
    	
        service.alterarBairro(bairro, id); //Recebe o bairro e o ID da URL para validar
        
    }

}
