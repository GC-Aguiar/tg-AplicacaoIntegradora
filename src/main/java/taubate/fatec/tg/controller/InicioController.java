package taubate.fatec.tg.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class InicioController {
	
    @GetMapping("/inicio")
    public String welcome(){
        return "Bem vindo ao Sistema Integrador de Dados Básicos do Munícipe (SI-DBM)";
    }
	

}

