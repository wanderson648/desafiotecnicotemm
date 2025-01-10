package com.temm.desafiotecnico.models;

import com.temm.desafiotecnico.models.dto.TransacaoDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    private BigDecimal valor;

    private String email;

    public Transacao() {
    }

    public Transacao(String email, TransacaoDTO dto) {
        this.email = email;
        this.tipoTransacao = dto.tipoTransacao();
        this.valor = dto.valor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
