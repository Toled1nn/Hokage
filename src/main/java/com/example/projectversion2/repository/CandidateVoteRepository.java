package com.example.projectversion2.repository;

import com.example.projectversion2.entity.CandidateEntity;
import com.example.projectversion2.entity.CandidateVoteEntity;
import com.example.projectversion2.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateVoteRepository extends JpaRepository<CandidateVoteEntity, Integer> {
    boolean existsByVoteEntityAndCandidateEntity(VoteEntity voteEntity, CandidateEntity candidateEntity);

    List<CandidateVoteEntity> findAllByVoteEntity(VoteEntity voteEntity);
}
