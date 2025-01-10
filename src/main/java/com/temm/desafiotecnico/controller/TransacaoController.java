package com.temm.desafiotecnico.controller;

import com.temm.desafiotecnico.models.Transacao;
import com.temm.desafiotecnico.models.dto.TransacaoDTO;
import com.temm.desafiotecnico.service.TransacaoService;
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
    public ResponseEntity<Transacao> createTransaction(@RequestParam String email,
                                                       @RequestBody TransacaoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(transacaoService.createTransaction(email, dto));
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listTransaction() {
        return ResponseEntity.ok(transacaoService.listTransactions());
    }
}
