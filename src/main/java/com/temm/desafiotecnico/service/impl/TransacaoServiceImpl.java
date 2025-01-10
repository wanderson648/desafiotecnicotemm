package com.temm.desafiotecnico.service.impl;

import com.temm.desafiotecnico.models.Transacao;
import com.temm.desafiotecnico.models.dto.TransacaoDTO;
import com.temm.desafiotecnico.repository.TransacaoRepository;
import com.temm.desafiotecnico.repository.UsuarioRepository;
import com.temm.desafiotecnico.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Transacao createTransaction(String email, TransacaoDTO dto) {
        boolean existsEmail = usuarioRepository.existsByEmail(email);
        if(!existsEmail) {
            throw  new RuntimeException("Email não encontrado");
        }
        return transacaoRepository.save(new Transacao(email, dto));
    }

    @Override
    public List<Transacao> listTransactions() {
        return transacaoRepository.findAll();
    }
}
