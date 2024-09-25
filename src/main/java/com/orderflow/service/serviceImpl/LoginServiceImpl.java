package com.orderflow.service.serviceImpl;

import com.orderflow.domain.Usuario;
import com.orderflow.domain.dto.LoginDTO;
import com.orderflow.exception.LoginMessage;
import com.orderflow.repository.UsuarioRepository;
import com.orderflow.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public LoginMessage login(LoginDTO loginDTO) {
        String msg = "";
        Usuario usuario1 = usuarioRepository.findByEmailUsuario(loginDTO.getEmail());

        if(usuario1 != null) {
            Boolean senhaEstaCorreta = passwordEncoder.matches(loginDTO.getSenha(), usuario1.getSenhaUsuario());

            if(senhaEstaCorreta) {
                return new LoginMessage("Sucesso ao realizar login", true);
            } else {
                return new LoginMessage("E-mail ou senha não estão corretos",false);
            }
        } else {
            return new LoginMessage("E-mail não encontrado",false);
        }
    }
}
