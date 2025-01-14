package com.temm.desafiotecnico.usuario.application.api;

import com.temm.desafiotecnico.usuario.application.service.AutenticaUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação")
public class AutenticaUsuarioController {

    @Autowired
    private AutenticaUsuarioService autenticaUsuarioService;

    @Operation(summary = "Autenticar usuário", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Autenticação  realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao autenticar usuário")
    })
    @PostMapping
    public ResponseEntity<Object> autentica(@RequestBody AutenticaUsuarioRequestDTO autenticaUsuarioRequestDTO) {
        try {
            var token = this.autenticaUsuarioService.autentica(autenticaUsuarioRequestDTO);
            return ResponseEntity.ok().body(token);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
