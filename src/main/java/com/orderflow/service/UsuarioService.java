package com.orderflow.service;

import com.orderflow.domain.Usuario;
import com.orderflow.domain.dto.UsuarioDTO;
import com.orderflow.exception.BadRequestException;

public interface UsuarioService {

    String registrarUsuario(UsuarioDTO usuarioDTO) throws BadRequestException;

}
