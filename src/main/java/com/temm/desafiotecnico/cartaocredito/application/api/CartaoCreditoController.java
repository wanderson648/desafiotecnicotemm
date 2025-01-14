package com.temm.desafiotecnico.cartaocredito.application.api;

import com.temm.desafiotecnico.cartaocredito.application.service.CartaoCreditoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@Tag(name = "Cartão de crédito")
@SecurityRequirement(name = "bearerAuth")
public class CartaoCreditoController {

    @Autowired
    private CartaoCreditoService cartaoCreditoService;

    @Operation(summary = "Cadastar novo cartão", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cadastro realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar novo cartão")
    })
    @PostMapping
    public ResponseEntity<CartaoCreditoResponseDTO> createCreditCard(
            @RequestParam String email, @RequestBody CartaoCreditoDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cartaoCreditoService.createCreditCard(email, dto));
    }

    @Operation(summary = "Listar cartões", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    @GetMapping
    public ResponseEntity<List<CartaoCreditoResponseDTO>> listCreditCards() {
        return ResponseEntity.ok(cartaoCreditoService.listCreditCard());
    }
}
