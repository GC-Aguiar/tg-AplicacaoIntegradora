package taubate.fatec.tg.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	
    @GetMapping("/inicio")
    public String welcome(){
        
    	return "inicio";
    }
	

}

