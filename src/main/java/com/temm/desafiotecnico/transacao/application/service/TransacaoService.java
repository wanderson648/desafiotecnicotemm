package com.temm.desafiotecnico.transacao.application.service;

import com.temm.desafiotecnico.transacao.application.api.TransacaoResponseDTO;
import com.temm.desafiotecnico.transacao.domain.Transacao;
import com.temm.desafiotecnico.transacao.application.api.TransacaoDTO;

import java.util.List;

public interface TransacaoService {

    TransacaoResponseDTO createTransaction(String email, TransacaoDTO dto);

    List<TransacaoResponseDTO> listTransactions();
}
