package com.temm.desafiotecnico.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.temm.desafiotecnico.models.dto.AutenticaUsuarioRequestDTO;
import com.temm.desafiotecnico.models.dto.AutenticaUsuarioResponseDTO;
import com.temm.desafiotecnico.repository.UsuarioRepository;
import com.temm.desafiotecnico.service.AutenticaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;

@Service
public class AutenticaUsuarioServiceImpl implements AutenticaUsuarioService {

    @Value("${security.token.secret.usuario}")
    private String secreteKey;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AutenticaUsuarioResponseDTO autentica(AutenticaUsuarioRequestDTO autenticaUsuarioRequestDTO) throws AuthenticationException {
        var usuario = usuarioRepository.findByEmail(autenticaUsuarioRequestDTO.email())
                .orElseThrow(() -> new UsernameNotFoundException("email/password incorrect"));

        var passwordMatches = passwordEncoder.matches(autenticaUsuarioRequestDTO.password(),
                usuario.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secreteKey);

        var expiresIn = Instant.now().plus(Duration.ofMinutes(10));

        var token = JWT.create()
                .withIssuer("desafio tecnico")
                .withSubject(usuario.getEmail())
                .withExpiresAt(expiresIn)
                .sign(algorithm);

        return new AutenticaUsuarioResponseDTO(token);
    }
}
