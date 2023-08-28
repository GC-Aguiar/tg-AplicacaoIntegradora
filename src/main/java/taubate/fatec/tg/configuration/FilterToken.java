package taubate.fatec.tg.configuration;


import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import taubate.fatec.tg.model.SistemaExterno;
import taubate.fatec.tg.repository.UsuarioRepository;
import taubate.fatec.tg.service.SistemaExternoService;
import taubate.fatec.tg.service.TokenService;

@Component
public class FilterToken extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private SistemaExternoService sistemaExternoService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token;

        var authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader != null) {
            token = authorizationHeader.replace("Bearer ", "");
            var subject = this.tokenService.getSubject(token);

            var usuario = this.usuarioRepository.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario,
                    null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            //** Novo *//
            System.out.println("Validação do token do usuário " + usuario.getLogin());
            //sistemaExternoService.incrementarAcessos(usuario.getCodigoSistema());
            Optional<SistemaExterno> sistemaExternoOptional = sistemaExternoService.buscarSistemaExternoPorId(usuario.getCodigoSistema());
            sistemaExternoService.incrementarAcessos(sistemaExternoOptional);

        }

        filterChain.doFilter(request, response);

    }
}