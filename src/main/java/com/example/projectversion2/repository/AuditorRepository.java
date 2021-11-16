package com.example.projectversion2.repository;

import com.example.projectversion2.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditorRepository extends JpaRepository<AuditorEntity, Integer> {
    boolean existsByUserEntityAndCandidateVoteEntity(UserEntity user, CandidateVoteEntity candidateVoteEntity);

    int countAllByCandidateVoteEntity(CandidateVoteEntity candidateVoteEntity);
}
