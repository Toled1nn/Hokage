package com.example.projectversion2.controller;

import com.example.projectversion2.dto.UserDTO;
import com.example.projectversion2.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("auth")
public class AuthController {

    @Autowired
    private AuthService services;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO user) {


        String token = services.login(user);

        if (token == null) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.add("Authorization", token);

        return ResponseEntity.ok().headers(responseHeader).build();
    }

    @Autowired
    private AuthService service;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDTO user) {

        int result = service.signup(user);

        if (result == 1) {
            //NOME
            return ResponseEntity.badRequest().body("Nome de usuário inválido");
        } else if (result == 2) {
            //CPF
            return ResponseEntity.badRequest().body("CPF inválido");
        } else if (result == 3) {
            //EMAIL
            return ResponseEntity.badRequest().body("Email inválido");

        } else if (result == 4) {
            return ResponseEntity.badRequest().body("Senha inválida");
            //SENHA
        } else if (result == 5) {
            return ResponseEntity.badRequest().body("CPF cadastrado");
        }

        return ResponseEntity.ok().build();
    }
}
