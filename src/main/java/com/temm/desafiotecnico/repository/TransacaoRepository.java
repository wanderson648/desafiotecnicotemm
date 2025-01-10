package com.temm.desafiotecnico.repository;

import com.temm.desafiotecnico.models.Transacao;
import com.temm.desafiotecnico.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
