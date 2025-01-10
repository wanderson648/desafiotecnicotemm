package com.temm.desafiotecnico.repository;

import com.temm.desafiotecnico.models.CartaoCredito;
import com.temm.desafiotecnico.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {
}
