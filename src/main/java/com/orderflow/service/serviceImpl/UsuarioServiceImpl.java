package com.orderflow.service.serviceImpl;

import com.orderflow.domain.Usuario;
import com.orderflow.domain.dto.UsuarioDTO;
import com.orderflow.exception.InternalServerErrorException;
import com.orderflow.repository.UsuarioRepository;
import com.orderflow.service.UsuarioService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String registrarUsuario(UsuarioDTO usuarioDTO) {

        if (usuarioRepository.findByEmailUsuario(usuarioDTO.getEmailUsuario()) != null) {
            throw new InternalServerErrorException("E-mail já cadastrado");
        }

        Usuario usuario = new Usuario(
                usuarioDTO.getCodigoUsuario(),
                usuarioDTO.getNomeUsuario(),
                usuarioDTO.getEmailUsuario(),

                this.passwordEncoder.encode(usuarioDTO.getSenhaUsuario())
        );

        usuarioRepository.save(usuario);

        return usuarioDTO.getNomeUsuario();
    }

}
