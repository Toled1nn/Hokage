package com.example.projectversion2.services;

import com.example.projectversion2.entity.CandidateEntity;
import com.example.projectversion2.entity.CandidateVoteEntity;
import com.example.projectversion2.entity.DataVoteEntity;
import com.example.projectversion2.entity.VoteEntity;
import com.example.projectversion2.repository.CandidateRepository;
import com.example.projectversion2.repository.CandidateVoteRepository;
import com.example.projectversion2.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateVoteService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidateVoteRepository candidateVoteRepository;

    public int cadastraCandidateVote(int IDVote, int IDCandidate) {
        Optional<CandidateEntity> candidateEntity = candidateRepository.findById(IDCandidate);
        Optional<VoteEntity> voteEntity = voteRepository.findById(IDVote);

        if (candidateEntity.isEmpty()) {
            return 1;
        }
        if (voteEntity.isEmpty()) {
            return 2;
        }

        if (candidateVoteRepository.existsByVoteEntityAndCandidateEntity(voteEntity.get(), candidateEntity.get())) {
            return 3;
        }

        CandidateVoteEntity candidateVoteEntity = new CandidateVoteEntity(voteEntity.get(), candidateEntity.get());
        candidateVoteRepository.save(candidateVoteEntity);

        DataVoteEntity dataVoteEntity = voteEntity.get().getDataVoteEntity();
        dataVoteEntity.setNumCandidate(dataVoteEntity.getNumCandidate() + 1);
        voteRepository.save(voteEntity.get());

        return 0;
    }
}
