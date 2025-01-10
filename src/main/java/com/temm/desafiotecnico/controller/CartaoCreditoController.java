package com.temm.desafiotecnico.controller;

import com.temm.desafiotecnico.models.CartaoCredito;
import com.temm.desafiotecnico.models.dto.CartaoCreditoDTO;
import com.temm.desafiotecnico.service.CartaoCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CartaoCreditoController {

    @Autowired
    private CartaoCreditoService cartaoCreditoService;

    @PostMapping
    public ResponseEntity<CartaoCredito> createCreditCard(
            @RequestParam String email, @RequestBody CartaoCreditoDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cartaoCreditoService.createCreditCard(email, dto));
    }

    @GetMapping
    public ResponseEntity<List<CartaoCredito>> listCreditCards() {
        return ResponseEntity.ok(cartaoCreditoService.listCreditCard());
    }
}
