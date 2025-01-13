package com.temm.desafiotecnico.cartaocredito.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record CartaoCreditoDTO(
        @NotBlank(message = "Incluir número do cartão")
        String numero,
        @NotBlank(message = "Incluir mês")
        String mes,
        @NotBlank(message = "Incluir ano")
        String ano,
        @NotBlank(message = "Incluir código do cartao")
        @Length(min = 3, max = 3, message = "Número de cvv inválido")
        String cvv,
        @NotNull(message = "Incluir saldo do cartão")
        BigDecimal saldo
) {
}
