package com.orderflow.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sobre")
@RestController
@CrossOrigin(origins = "*")
public class SobreController {

    @GetMapping
    public String sobre() {
        return "OrderFlow - /sobr";
    }


}
