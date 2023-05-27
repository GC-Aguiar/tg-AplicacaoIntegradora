package taubate.fatec.tg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import taubate.fatec.tg.dto.Login;
import taubate.fatec.tg.model.Usuario;
import taubate.fatec.tg.service.TokenService;

@RestController
@Api(tags = "Autenticação", description = "Permite a realização da autenticação na API.")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @ApiOperation(value = "Realizar autenticação", notes = "Retorna um token JWT após a autenticação com sucesso.", hidden = false)
    @PostMapping("/login")
    public String login(@RequestBody Login login) {
    	System.out.println("Início do processo de login");
    	
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.login(),
                        login.password());

        Authentication authenticate = this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);

        var usuario = (Usuario) authenticate.getPrincipal();
        System.out.println("Usuário " + usuario.getLogin() + "autenticado com sucesso");

        return tokenService.gerarToken(usuario);

    }
}