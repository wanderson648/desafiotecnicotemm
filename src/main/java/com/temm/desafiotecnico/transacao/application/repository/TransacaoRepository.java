package com.temm.desafiotecnico.transacao.application.repository;

import com.temm.desafiotecnico.transacao.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
