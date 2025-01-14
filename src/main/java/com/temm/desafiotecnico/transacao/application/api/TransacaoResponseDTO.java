package com.temm.desafiotecnico.transacao.application.api;

import com.temm.desafiotecnico.transacao.domain.TipoTransacao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransacaoResponseDTO(
        TipoTransacao tipoTransacao,
        BigDecimal valor,
        String email
) {
        public TransacaoResponseDTO(String email, TransacaoDTO dto) {
                this(dto.tipoTransacao(), dto.valor(), email);
        }
}
