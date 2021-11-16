package com.example.projectversion2.controller;


import com.example.projectversion2.dto.CandidateDTO;
import com.example.projectversion2.services.AuthCandidateService;
import com.example.projectversion2.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//todo: Cadastro de Candidatos

@RestController
public class AuthCandidateController {

    @Autowired
    private AuthCandidateService authCandidateService;

    @Autowired
    private AuthService authService;

    @PostMapping("/cadastrar-candidatos")
    public ResponseEntity<String> cadastraCandidato(@RequestParam int userID, @RequestBody CandidateDTO candidate) {

        int ret = authService.checkPermission(userID);
        if (ret == 1) {
            return new ResponseEntity<>("Acesso não autorizado.", HttpStatus.FORBIDDEN);
        }

        int ans = authCandidateService.registerCandidate(candidate);

        if (ans == 1) {
            return new ResponseEntity<>("Candidato já existe", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Candidato criado", HttpStatus.CREATED);
    }
}
