package com.temm.desafiotecnico.service;

import com.temm.desafiotecnico.models.Usuario;
import com.temm.desafiotecnico.models.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    Usuario createUser(UsuarioDTO dto);

    List<Usuario> listUsers();
}
