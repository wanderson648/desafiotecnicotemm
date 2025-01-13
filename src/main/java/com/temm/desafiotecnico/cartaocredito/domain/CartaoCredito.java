package com.temm.desafiotecnico.cartaocredito.domain;

import com.temm.desafiotecnico.cartaocredito.application.api.CartaoCreditoDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "cartoes")
public class CartaoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private String mes;

    private String ano;

    private String cvv;

    private BigDecimal saldo;

    private String emailUsuario;

    public CartaoCredito() {
    }

    public CartaoCredito(String email, CartaoCreditoDTO dto) {
        this.numero = dto.numero();
        this.mes = dto.mes();
        this.ano = dto.ano();
        this.cvv = dto.cvv();
        this.saldo = dto.saldo();
        this.emailUsuario = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CartaoCredito that = (CartaoCredito) o;
        return Objects.equals(emailUsuario, that.emailUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(emailUsuario);
    }
}
