package com.example.projectversion2.controller;

import com.example.projectversion2.services.AuthService;
import com.example.projectversion2.services.CandidateVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateVoteController {

    @Autowired
    private AuthService authService;

    @Autowired
    private CandidateVoteService candidateVoteService;

    @PostMapping("/candidate-vote")
    public ResponseEntity<String> CandidateVote(@RequestParam int idVote, @RequestParam int IDCandidate, @RequestParam int userID){
        int ret = authService.checkPermission(userID);
        if (ret == 1) {
            return new ResponseEntity<>("Acesso não autorizado.", HttpStatus.FORBIDDEN);
        }

        int retorno = candidateVoteService.cadastraCandidateVote(idVote, IDCandidate);

        if (retorno == 1){
            return new ResponseEntity<>("Entidade Candidato não existe", HttpStatus.BAD_REQUEST);
        }else if(retorno == 2){
            return new ResponseEntity<>("Entidade Vote não existe", HttpStatus.BAD_REQUEST);
        }else if (retorno == 3){
            return new ResponseEntity<>("Entidade Candidato Vote já existe", HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>("Entidade Candidato Vote criada", HttpStatus.CREATED);
        }
    }

}
