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
        Usuario usuario = usuarioRepository.findByEmail(loginDTO.getEmail());

        if(usuario != null) {
            String senha = loginDTO.getSenha();
            String encodedSenha = usuario.getSenhaUsuario();
            Boolean senhaEstaCorreta = passwordEncoder.matches(loginDTO.getSenha(), encodedSenha);

            if(senhaEstaCorreta) {
                Optional<Usuario> usuarioOptional = usuarioRepository.findOneByEmailAndSenha(loginDTO.getEmail(), loginDTO.getSenha());

                if(usuarioOptional.isPresent()) {
                    return new LoginMessage("Sucesso ao realizar login", true);
                } else {
                    return new LoginMessage("Falha ao realizar login",false);
                }
            } else {
                return new LoginMessage("E-mail ou senha não estão corretos",false);
            }
        } else {
            return new LoginMessage("E-mail não encontrado",false);
        }
    }
}
