package taubate.fatec.tg.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class InicioController {
	
    @GetMapping("/inicio")
    @ApiOperation(value = "Início", hidden = true)
    public String welcome(){
        
    	return "inicio";
    }
	

}

