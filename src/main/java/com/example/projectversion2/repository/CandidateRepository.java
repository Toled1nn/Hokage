package com.example.projectversion2.repository;

import com.example.projectversion2.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity, Integer> {
    boolean existsByHolderCPF(String substituteCPF);
    boolean existsByHolderCPFAndSubstituteCPF(String holderCPF, String substituteCPF);

    // ID 1, Nome TOTO, holderCPF 123, substituteCPF 456
    // ID 2, Nome RAF, holderCPF 789, substituteCPF 456
    // ID 3, Nome Joao, holderCPF 456, substitute 523
}
