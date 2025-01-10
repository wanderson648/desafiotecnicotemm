package com.temm.desafiotecnico.service;

import com.temm.desafiotecnico.models.Transacao;
import com.temm.desafiotecnico.models.dto.TransacaoDTO;

import java.util.List;

public interface TransacaoService {

    Transacao createTransaction(String email, TransacaoDTO dto);

    List<Transacao> listTransactions();
}
