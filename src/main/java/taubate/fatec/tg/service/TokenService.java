package taubate.fatec.tg.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import taubate.fatec.tg.model.Usuario;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String gerarToken(Usuario usuario) {
        return JWT.create()
                .withIssuer("SI-DBM")
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getCodigo())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(240)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("secreta"));
    }


    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("secreta"))
                .withIssuer("SI-DBM")
                .build().verify(token).getSubject();

    }
}