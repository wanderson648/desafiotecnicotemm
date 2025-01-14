package com.temm.desafiotecnico.cartaocredito.application.api;

import java.math.BigDecimal;

public record CartaoCreditoResponseDTO(
        String numero,
        String mes,
        String ano,
        String cvv,
        BigDecimal saldo,
        String email
) {
    public CartaoCreditoResponseDTO(String email, CartaoCreditoDTO dto) {
        this(dto.numero(), dto.mes(), dto.ano(), dto.cvv(), dto.saldo(), email);
    }
}
