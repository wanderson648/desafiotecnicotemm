package com.temm.desafiotecnico.service.impl;

import com.temm.desafiotecnico.models.CartaoCredito;
import com.temm.desafiotecnico.models.Usuario;
import com.temm.desafiotecnico.models.dto.CartaoCreditoDTO;
import com.temm.desafiotecnico.repository.CartaoCreditoRepository;
import com.temm.desafiotecnico.repository.UsuarioRepository;
import com.temm.desafiotecnico.service.CartaoCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoCreditoServiceImpl implements CartaoCreditoService {

    @Autowired
    private CartaoCreditoRepository cartaoCreditoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public CartaoCredito createCreditCard(String email, CartaoCreditoDTO dto) {
        boolean existsEmail = usuarioRepository.existsByEmail(email);

        if(!existsEmail) {
            throw  new RuntimeException("Email não encontrado");
        }
        return cartaoCreditoRepository.save(new CartaoCredito(email, dto));
    }

    @Override
    public List<CartaoCredito> listCreditCard() {
        return cartaoCreditoRepository.findAll();
    }
}
