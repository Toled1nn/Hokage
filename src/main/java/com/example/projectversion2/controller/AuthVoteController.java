package com.example.projectversion2.controller;
//todo: Cadastra a eleição

import com.example.projectversion2.services.AuthService;
import com.example.projectversion2.services.AuthVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthVoteController {

    @Autowired
    private AuthVoteService authVoteService;

    @Autowired
    private AuthService authService;

    @PostMapping("/register-vote")
    public ResponseEntity<String> register_vote(@RequestParam int userID){

        int ret = authService.checkPermission(userID);
        if (ret == 1) {
            return new ResponseEntity<>("Acesso não autorizado.", HttpStatus.FORBIDDEN);
        }

        authVoteService.register();

        return  new ResponseEntity<>("Votação criada", HttpStatus.CREATED);
    }
}
