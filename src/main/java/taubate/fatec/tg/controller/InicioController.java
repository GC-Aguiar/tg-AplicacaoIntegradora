package taubate.fatec.tg.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class InicioController {
	
    @GetMapping("/inicio")
    public String welcome(){
        
    	return "inicio";
    }
	

}

