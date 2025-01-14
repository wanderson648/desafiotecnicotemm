package com.temm.desafiotecnico.usuario.application.service.impl;

import com.temm.desafiotecnico.usuario.domain.Usuario;
import com.temm.desafiotecnico.usuario.application.api.UsuarioDTO;
import com.temm.desafiotecnico.usuario.application.api.UsuarioResponseDTO;
import com.temm.desafiotecnico.usuario.application.repository.UsuarioRepository;
import com.temm.desafiotecnico.usuario.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponseDTO createUser(UsuarioDTO dto) {
        Usuario user = new Usuario();
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        usuarioRepository.save(user);

        return new UsuarioResponseDTO(user.getEmail(), user.getPassword());
    }

    @Override
    public List<Usuario> listUsers() {
        return usuarioRepository.findAll();
    }
}
