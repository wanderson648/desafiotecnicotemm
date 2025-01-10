package com.temm.desafiotecnico.service;

import com.temm.desafiotecnico.models.Transacao;
import com.temm.desafiotecnico.models.dto.TransacaoDTO;

import java.util.List;

public interface TransacaoService {

    Transacao createTransaction(TransacaoDTO dto);

    List<Transacao> listTransactions();
}
