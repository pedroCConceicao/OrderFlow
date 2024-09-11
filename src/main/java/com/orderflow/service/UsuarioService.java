package com.orderflow.service;

import com.orderflow.domain.Usuario;
import com.orderflow.domain.dto.UsuarioDTO;

public interface UsuarioService {

    String registrarUsuario(UsuarioDTO usuarioDTO);

}
