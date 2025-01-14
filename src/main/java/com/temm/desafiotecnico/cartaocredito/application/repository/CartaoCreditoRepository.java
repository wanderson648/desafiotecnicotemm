package com.temm.desafiotecnico.cartaocredito.application.repository;

import com.temm.desafiotecnico.cartaocredito.domain.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {
}
