package com.temm.desafiotecnico.usuario.application.api;

import com.temm.desafiotecnico.usuario.domain.Usuario;
import com.temm.desafiotecnico.usuario.application.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "middleware-bff-api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> createUser(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.createUser(dto));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listUsers() {
        return ResponseEntity.ok(usuarioService.listUsers());
    }
}
