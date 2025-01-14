package com.temm.desafiotecnico.usuario.application.service;

import com.temm.desafiotecnico.usuario.domain.Usuario;
import com.temm.desafiotecnico.usuario.application.api.UsuarioDTO;
import com.temm.desafiotecnico.usuario.application.api.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {

    UsuarioResponseDTO createUser(UsuarioDTO dto);

    List<Usuario> listUsers();
}
