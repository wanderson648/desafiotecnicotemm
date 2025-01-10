package com.temm.desafiotecnico.models.dto;

import com.temm.desafiotecnico.models.TipoTransacao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransacaoDTO(
        @NotBlank(message = "Informe o tipo de transação")
        @Enumerated(EnumType.STRING)
        TipoTransacao tipoTransacao,
        @NotNull(message = "Informe o valor da transação")
        BigDecimal valor
) {
}
