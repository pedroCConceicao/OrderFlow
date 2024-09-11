package com.orderflow.controller;

import com.orderflow.domain.dto.UsuarioDTO;
import com.orderflow.exception.BadRequestException;
import com.orderflow.exception.InternalServerErrorException;
import com.orderflow.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrarUsuario")
    public String registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws BadRequestException {
        try {
            String id = usuarioService.registrarUsuario(usuarioDTO);
            return id;
        } catch(BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch(InternalServerErrorException e) {
            throw new InternalServerErrorException(e.getMessage());
        }

    }

}
