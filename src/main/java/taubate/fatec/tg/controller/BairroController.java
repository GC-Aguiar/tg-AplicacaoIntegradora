package taubate.fatec.tg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taubate.fatec.tg.model.Bairro;
import taubate.fatec.tg.service.BairroService;

@RestController
@RequestMapping("/bairros")
public class BairroController {
	
	@Autowired
	private BairroService bairro;
		
	@GetMapping
    public List<Bairro> listar(){
    	System.out.println("List");
        return bairro.buscarBairros();
    }
	
    @GetMapping("/{id}")
    public Optional<Bairro> buscarPorId(@PathVariable ("id") Integer id){
    	return bairro.buscarBairroPorId(id);	
    	
    }
    
    @GetMapping("/regiao/{regiao}")
    public List<String> buscaPorRegiao(@PathVariable ("regiao") String regiao){
    	return bairro.buscarBairroPorRegiao(regiao);
    	
    }

}
