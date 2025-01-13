package com.temm.desafiotecnico.transacao.application.api;

import com.temm.desafiotecnico.transacao.domain.Transacao;
import com.temm.desafiotecnico.transacao.application.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> createTransaction(@RequestParam String email,
                                                                  @RequestBody TransacaoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(transacaoService.createTransaction(email, dto));
    }

    @GetMapping
    public ResponseEntity<List<TransacaoResponseDTO>> listTransaction() {
        return ResponseEntity.ok(transacaoService.listTransactions());
    }
}
