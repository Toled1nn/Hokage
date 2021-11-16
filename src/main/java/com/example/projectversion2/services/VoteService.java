package com.example.projectversion2.services;

import com.example.projectversion2.entity.*;
import com.example.projectversion2.repository.AuditorRepository;
import com.example.projectversion2.repository.CandidateVoteRepository;
import com.example.projectversion2.repository.UserRepository;
import com.example.projectversion2.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

//todo: Cadastrar voto do usuário
@Service
public class VoteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CandidateVoteRepository candidateVoteRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private AuditorRepository auditorRepository;

    public int registerVote(int userID, int CandidateVoteId) {

        Optional<UserEntity> user = userRepository.findById(userID);
        if (user.isEmpty()) {
            return 1;
        }

        Optional<CandidateVoteEntity> candidateVoteEntity = candidateVoteRepository.findById(CandidateVoteId);
        if (candidateVoteEntity.isEmpty()) {
            return 2;
        }

        if (auditorRepository.existsByUserEntityAndCandidateVoteEntity(user.get(), candidateVoteEntity.get())) {
            return 3;
        }

        if (!candidateVoteEntity.get().getVoteEntity().isStatus()) {
            return 4;
        }

        AuditorEntity auditorEntity = new AuditorEntity(user.get(), candidateVoteEntity.get(), LocalDateTime.now());
        auditorRepository.save(auditorEntity);

        Optional<VoteEntity> voteEntity = voteRepository.findById(candidateVoteEntity.get().getVoteEntity().getID_vote());

        if (voteEntity.isPresent()) {
            DataVoteEntity dataVoteEntity = voteEntity.get().getDataVoteEntity();
            dataVoteEntity.setQtdVoting(dataVoteEntity.getQtdVoting() + 1);
            voteEntity.get().setDataVoteEntity(dataVoteEntity);

            voteRepository.save(voteEntity.get());
        }

        return 0;
    }

}
