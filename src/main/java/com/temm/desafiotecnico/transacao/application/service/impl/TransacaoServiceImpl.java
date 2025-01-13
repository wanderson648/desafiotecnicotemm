package com.temm.desafiotecnico.transacao.application.service.impl;

import com.temm.desafiotecnico.transacao.application.api.TransacaoResponseDTO;
import com.temm.desafiotecnico.transacao.domain.Transacao;
import com.temm.desafiotecnico.transacao.application.api.TransacaoDTO;
import com.temm.desafiotecnico.transacao.application.repository.TransacaoRepository;
import com.temm.desafiotecnico.usuario.application.repository.UsuarioRepository;
import com.temm.desafiotecnico.transacao.application.service.TransacaoService;
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
    public TransacaoResponseDTO createTransaction(String email, TransacaoDTO dto) {
        boolean existsEmail = usuarioRepository.existsByEmail(email);
        if (!existsEmail) {
            throw new RuntimeException("Email não encontrado");
        }
        transacaoRepository.save(new Transacao(email, dto));
        return new TransacaoResponseDTO(email, dto);
    }

    @Override
    public List<TransacaoResponseDTO> listTransactions() {
        return transacaoRepository.findAll().stream()
                .map(transacao -> new TransacaoResponseDTO(
                        transacao.getTipoTransacao(),
                        transacao.getValor(),
                        transacao.getEmail())).toList();
    }
}
