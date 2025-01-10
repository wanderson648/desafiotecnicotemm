package com.temm.desafiotecnico.service.impl;

import com.temm.desafiotecnico.models.Usuario;
import com.temm.desafiotecnico.models.dto.UsuarioDTO;
import com.temm.desafiotecnico.repository.UsuarioRepository;
import com.temm.desafiotecnico.service.UsuarioService;
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
    public Usuario createUser(UsuarioDTO dto) {
        Usuario user = new Usuario();
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));

        return usuarioRepository.save(user);
    }

    @Override
    public List<Usuario> listUsers() {
        return usuarioRepository.findAll();
    }
}
