package com.example.projectversion2.services;
//todo: Altera o status da eleição
//      1) Pesquisa se há votação com o ID -> return 1; (Votação Inexistente)
//      2) Pegar o status da votação e verificar os critérios para alteração.
//      2.1) Critério false->true // Mínimo 2 Candidatos -> return 2; (Candidatos Insuficentes);
//                                                          return 3; (Eleição ativa);
//      2.2) Critério true->false // Nenhum critério -> return 4; (Eleição Encerrada);

import com.example.projectversion2.entity.DataVoteEntity;
import com.example.projectversion2.entity.VoteEntity;
import com.example.projectversion2.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AlterStatusVoteService {

    @Autowired
    private VoteRepository voteRepository;

    public int alterStatus(int idVote) {
        Optional<VoteEntity> voteEntity = voteRepository.findById(idVote);

        if (voteEntity.isEmpty()) {
            return 1;
        }

        return updateStatusService(voteEntity.get());
    }

    private int updateStatusService(VoteEntity voteEntity){
        DataVoteEntity dataVoteEntity = voteEntity.getDataVoteEntity();
        if (voteEntity.isStatus()) {
            voteEntity.setStatus(false);
            dataVoteEntity.setClose(LocalDateTime.now());
            voteEntity.setDataVoteEntity(dataVoteEntity);
            voteRepository.save(voteEntity);

            return 3;
        }else if(dataVoteEntity.getNumCandidate() >= 2){
            voteEntity.setStatus(true);
            dataVoteEntity.setOpen(LocalDateTime.now());
            voteEntity.setDataVoteEntity(dataVoteEntity);
            voteRepository.save(voteEntity);

            return 4;
        } else{
            return 2;
        }

    }
}
