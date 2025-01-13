package com.temm.desafiotecnico.cartaocredito.application.api;

import com.temm.desafiotecnico.cartaocredito.application.service.CartaoCreditoService;
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
    public ResponseEntity<CartaoCreditoResponseDTO> createCreditCard(
            @RequestParam String email, @RequestBody CartaoCreditoDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cartaoCreditoService.createCreditCard(email, dto));
    }

    @GetMapping
    public ResponseEntity<List<CartaoCreditoResponseDTO>> listCreditCards() {
        return ResponseEntity.ok(cartaoCreditoService.listCreditCard());
    }
}
