package com.temm.desafiotecnico.usuario.application.service;

import com.temm.desafiotecnico.usuario.application.api.AutenticaUsuarioRequestDTO;
import com.temm.desafiotecnico.usuario.application.api.AutenticaUsuarioResponseDTO;

import javax.naming.AuthenticationException;

public interface AutenticaUsuarioService {

    AutenticaUsuarioResponseDTO autentica(AutenticaUsuarioRequestDTO autenticaUsuarioRequestDTO) throws AuthenticationException;
}
