package com.temm.desafiotecnico.controller;

import com.temm.desafiotecnico.models.dto.AutenticaUsuarioRequestDTO;
import com.temm.desafiotecnico.service.AutenticaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticaUsuarioController {

    @Autowired
    private AutenticaUsuarioService autenticaUsuarioService;

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
