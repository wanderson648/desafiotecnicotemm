package com.temm.desafiotecnico.cartaocredito.application.service.impl;

import com.temm.desafiotecnico.cartaocredito.application.api.CartaoCreditoResponseDTO;
import com.temm.desafiotecnico.cartaocredito.domain.CartaoCredito;
import com.temm.desafiotecnico.cartaocredito.application.api.CartaoCreditoDTO;
import com.temm.desafiotecnico.cartaocredito.application.repository.CartaoCreditoRepository;
import com.temm.desafiotecnico.usuario.application.repository.UsuarioRepository;
import com.temm.desafiotecnico.cartaocredito.application.service.CartaoCreditoService;
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
    public CartaoCreditoResponseDTO createCreditCard(String email, CartaoCreditoDTO dto) {
        boolean existsEmail = usuarioRepository.existsByEmail(email);

        if (!existsEmail) {
            throw new RuntimeException("Email não encontrado");
        }
        cartaoCreditoRepository.save(new CartaoCredito(email, dto));
        return new CartaoCreditoResponseDTO(email, dto);
    }

    @Override
    public List<CartaoCreditoResponseDTO> listCreditCard() {
        return cartaoCreditoRepository.findAll().stream()
                .map(cartaoCredito ->
                        new CartaoCreditoResponseDTO(
                                cartaoCredito.getNumero(),
                                cartaoCredito.getCvv(),
                                cartaoCredito.getMes(),
                                cartaoCredito.getAno(),
                                cartaoCredito.getSaldo(),
                                cartaoCredito.getEmailUsuario())).toList();
    }
}
