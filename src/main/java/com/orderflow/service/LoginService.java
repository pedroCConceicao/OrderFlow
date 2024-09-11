package com.orderflow.service;

import com.orderflow.domain.dto.LoginDTO;
import com.orderflow.exception.LoginMessage;
import org.springframework.stereotype.Service;

public interface LoginService {

    LoginMessage login(LoginDTO loginDTO);

}
