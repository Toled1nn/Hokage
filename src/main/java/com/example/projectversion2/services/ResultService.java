package com.example.projectversion2.services;

import com.example.projectversion2.entity.CandidateVoteEntity;
import com.example.projectversion2.entity.VoteEntity;
import com.example.projectversion2.repository.AuditorRepository;
import com.example.projectversion2.repository.CandidateVoteRepository;
import com.example.projectversion2.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private AuditorRepository auditorRepository;

    @Autowired
    private CandidateVoteRepository candidateVoteRepository;

    public List<String> resultVote(int idVote) {
        Optional<VoteEntity> voteEntity = voteRepository.findById(idVote);

        if (voteEntity.isEmpty()) {
            return null;
        }

        if (voteEntity.get().isStatus()) {
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();

        List<CandidateVoteEntity> candidateVoteEntities = candidateVoteRepository.findAllByVoteEntity(voteEntity.get());

        candidateVoteEntities.forEach(candidateVoteEntity -> {
            list.add(String.format("Candidato %s, Total votos = %d", candidateVoteEntity.getCandidateEntity().getHolderName(), auditorRepository.countAllByCandidateVoteEntity(candidateVoteEntity)));
        });

        return list;
    }
}
