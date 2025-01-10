package com.temm.desafiotecnico.service.impl;

import com.temm.desafiotecnico.models.Transacao;
import com.temm.desafiotecnico.models.dto.TransacaoDTO;
import com.temm.desafiotecnico.repository.TransacaoRepository;
import com.temm.desafiotecnico.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Override
    public Transacao createTransaction(TransacaoDTO dto) {
        return null;
    }

    @Override
    public List<Transacao> listTransactions() {
        return List.of();
    }
}
