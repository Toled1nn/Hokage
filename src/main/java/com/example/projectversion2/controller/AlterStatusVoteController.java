package com.example.projectversion2.controller;

import com.example.projectversion2.services.AlterStatusVoteService;
import com.example.projectversion2.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//todo: Altera o status da votação;
//      1) Recebe o ID da Votação;
//      2) Retornar Status da Votação;
@RestController
public class AlterStatusVoteController {

    @Autowired
    private AlterStatusVoteService alterStatusVoteService;

    @Autowired
    private AuthService authService;

    @PostMapping("/alter-status-vote/{idVote}")
    public ResponseEntity<String> AlterStatusVote(@PathVariable("idVote") int idVote, @RequestParam int userID) {
        //http://localhost:8080/alter-status-vote/1?userID=1

        int ret = authService.checkPermission(userID);
        if (ret == 1) {
            return new ResponseEntity<>("Acesso não autorizado.", HttpStatus.FORBIDDEN);
        }

        int temp = alterStatusVoteService.alterStatus(idVote);

        if (temp == 1) {
            return new ResponseEntity<>("Votação Não Encontrada", HttpStatus.NOT_FOUND);
        } else if (temp == 2) {
            return new ResponseEntity<>("Candidatos Insuficientes", HttpStatus.BAD_REQUEST);
        } else if (temp == 3) {
            return new ResponseEntity<>("Votação Encerrada", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Votação Aberta", HttpStatus.OK);
        }
    }
}
