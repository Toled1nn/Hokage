package com.example.projectversion2.controller;
//todo: Página que mostra o resultado
//      1) Receber do usuário o ID da Votação que ele deseja ver o Resultado.
//      2) Se a eleição estiver ativa, printar que a eleição está em andamento.
//      3) Se a eleição estiver desativada, printar os candidatos e seus votos;

import com.example.projectversion2.services.AlterStatusVoteService;
import com.example.projectversion2.services.AuditorService;
import com.example.projectversion2.services.CandidateService;
import com.example.projectversion2.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultController {

    @Autowired
    private AlterStatusVoteService service;

    @Autowired
    private ResultService resultService;

    @GetMapping("/result")
    public ResponseEntity<?> ResultVote(@RequestParam int idVote) {

        List<String> result = resultService.resultVote(idVote);

        if (result == null) {
            return ResponseEntity.notFound().build();
        } else if (result.isEmpty()) {
            return ResponseEntity.badRequest().body("Eleição Ativa");
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
