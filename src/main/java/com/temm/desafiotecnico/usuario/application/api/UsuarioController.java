package com.temm.desafiotecnico.usuario.application.api;

import com.temm.desafiotecnico.usuario.domain.Usuario;
import com.temm.desafiotecnico.usuario.application.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Cadastrar Usuário", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cadastro realizado com sucesso")
    })
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> createUser(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.createUser(dto));
    }

    @Operation(summary = "Listar usuários", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    @GetMapping
    public ResponseEntity<List<Usuario>> listUsers() {
        return ResponseEntity.ok(usuarioService.listUsers());
    }
}
