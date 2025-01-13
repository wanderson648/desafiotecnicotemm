package com.temm.desafiotecnico.cartaocredito.application.service;

import com.temm.desafiotecnico.cartaocredito.application.api.CartaoCreditoResponseDTO;
import com.temm.desafiotecnico.cartaocredito.domain.CartaoCredito;
import com.temm.desafiotecnico.cartaocredito.application.api.CartaoCreditoDTO;

import java.util.List;

public interface CartaoCreditoService {

    CartaoCreditoResponseDTO createCreditCard(String email, CartaoCreditoDTO dto);

    List<CartaoCreditoResponseDTO> listCreditCard();
}
