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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import taubate.fatec.tg.model.Uf;
import taubate.fatec.tg.service.UfService;

@RestController
@RequestMapping("/ufs")
@Api(tags = "UF", description = "Retorna dados referentes às UFs.")
public class UfController {
	
	@Autowired
	private UfService service;
	
	@ApiOperation(value = "Listar UFs", notes = "Retorna todas as UFs", hidden = false)
	@GetMapping
    public List<Uf> listar(){
    	System.out.println("List");
        return service.buscarUfs();
    }
	
	@ApiOperation(value = "Buscar UF por ID", notes = "Retorna uma UF dado o ID", hidden = false)
	@GetMapping("/{id}")
    public Optional<Uf> buscarPorId(@PathVariable ("id") Integer id){
    	return service.buscarUfPorId(id);	
    	
    }
    
	@ApiOperation(value = "Buscar UF por região", notes = "Retorna as UF de uma determinada região", hidden = false)
    @GetMapping("/regiao/{regiao}")
    public List<String> buscaPorRegiao(@PathVariable ("regiao") String regiao){
    	return service.buscarUfPorRegiao(regiao);    	
    }
    
    @ApiOperation(value = "Inserir nova UF", notes = "Salva uma nova UF", hidden = true)
    @PostMapping
    public void save(@RequestBody Uf uf){
    	System.out.println("Save");
    	System.out.println(uf);    	
        service.gravarUf(uf);
    }
    
    @ApiOperation(value = "Excluir UF", notes = "Exclui uma UF", hidden = true)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.deletarUf(id);
    }
    
    @ApiOperation(value = "Alterar UF", notes = "Altera uma UF", hidden = true)
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Uf uf){
    	System.out.println("Update");
    	System.out.println(uf);
    	
        service.alterarUf(uf, id); //Recebe o bairro e o ID da URL para validar
        
    }

}
