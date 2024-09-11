package com.orderflow.controller;

import com.orderflow.domain.dto.LoginDTO;
import com.orderflow.exception.LoginMessage;
import com.orderflow.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {

        LoginMessage loginMessage = loginService.login(loginDTO);

        return ResponseEntity.ok(loginMessage);

    }

}
