package com.temm.desafiotecnico.transacao.application.api;

import com.temm.desafiotecnico.transacao.domain.Transacao;
import com.temm.desafiotecnico.transacao.application.service.TransacaoService;
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
@RequestMapping("/transactions")
@Tag(name = "Transações")
@SecurityRequirement(name = "bearerAuth")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Operation(summary = "Realizar transação", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao realizar transação")
    })
    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> createTransaction(@RequestParam String email,
                                                                  @RequestBody TransacaoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(transacaoService.createTransaction(email, dto));
    }

    @Operation(summary = "Listar transações", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    @GetMapping
    public ResponseEntity<List<TransacaoResponseDTO>> listTransaction() {
        return ResponseEntity.ok(transacaoService.listTransactions());
    }
}
