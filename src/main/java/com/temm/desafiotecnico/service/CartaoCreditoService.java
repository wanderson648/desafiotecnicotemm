package com.temm.desafiotecnico.service;

import com.temm.desafiotecnico.models.CartaoCredito;
import com.temm.desafiotecnico.models.dto.CartaoCreditoDTO;

import java.util.List;

public interface CartaoCreditoService {

    CartaoCredito createCreditCard(String email, CartaoCreditoDTO dto);

    List<CartaoCredito> listCreditCard();
}
