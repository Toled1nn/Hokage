package com.example.projectversion2.controller;
//todo: Página de Votação

import com.example.projectversion2.services.AuthService;
import com.example.projectversion2.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoteController {

    @Autowired
    private AuthService service;

    @Autowired
    private VoteService services;

    @PostMapping("/vote/{idCandidateVote}")
    public ResponseEntity<String> Vote(@RequestParam int userID, @PathVariable("idCandidateVote") int idCandidateVote) {
        int ret = service.checkPermission(userID);
        if (ret == 0) {
            return new ResponseEntity<>("Acesso não autorizado.", HttpStatus.FORBIDDEN);
        }

        int retorno = services.registerVote(userID, idCandidateVote);

        if (retorno == 1) {
            return new ResponseEntity<>("Usuário não existe", HttpStatus.NOT_FOUND);
        } else if (retorno == 2) {
                return new ResponseEntity<>("Entidade Candidato Voto não existe", HttpStatus.NOT_FOUND);
        } else if (retorno == 3) {
            return new ResponseEntity<>("Voto já computado", HttpStatus.BAD_REQUEST);
        }else if (retorno == 4){
            return new ResponseEntity<>("Votação não está aberta", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Voto computado", HttpStatus.CREATED);
    }
}
