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

import taubate.fatec.tg.model.Empresa;
import taubate.fatec.tg.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service ;
		
	@GetMapping
    public List<Empresa> listar(){
    	System.out.println("List");
        return service.buscarEmpresas();
    }
	
	 @GetMapping("/{id}")
	    public Optional<Empresa> buscarPorId(@PathVariable ("id") Integer id){
	    	return service.buscarEmpresaPorId(id);	
	    	
	    }
	    
	    @GetMapping("/cnpj/{cnpj}")
	    public List<String> buscaPorRegiao(@PathVariable ("cnpj") String cnpj){
	    	return service.buscarEmpresaPorCnpj(cnpj);    	
	    }
	    
	    @PostMapping
	    public void save(@RequestBody Empresa empresa){
	    	System.out.println("Save");
	    	System.out.println(empresa);    	
	        service.gravarEmpresa(empresa);
	    }
	    
	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable("id") Integer id){
	        service.deletarEmpresa(id);
	    }
	    
	    @PutMapping("/{id}")
	    public void update(@PathVariable("id") Integer id, @RequestBody Empresa empresa){
	    	System.out.println("Update");
	    	System.out.println(empresa);
	    	
	        service.alterarEmpresa(empresa, id); //Recebe o empresa e o ID da URL para validar
	        
	    }

}
