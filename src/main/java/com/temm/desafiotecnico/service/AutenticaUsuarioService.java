package com.temm.desafiotecnico.service;

import com.temm.desafiotecnico.models.dto.AutenticaUsuarioRequestDTO;
import com.temm.desafiotecnico.models.dto.AutenticaUsuarioResponseDTO;

import javax.naming.AuthenticationException;

public interface AutenticaUsuarioService {

    AutenticaUsuarioResponseDTO autentica(AutenticaUsuarioRequestDTO autenticaUsuarioRequestDTO) throws AuthenticationException;
}
