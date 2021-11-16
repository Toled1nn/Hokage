package com.example.projectversion2.services;

//todo: Serviço de Cadastro de Candidatos

import com.example.projectversion2.dto.CandidateDTO;
import com.example.projectversion2.entity.CandidateEntity;
import com.example.projectversion2.entity.builder.CandidateEntityBuilder;
import com.example.projectversion2.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public int registerCandidate(CandidateDTO candidate) {
        boolean retorno1 = candidateRepository.existsByHolderCPF(candidate.getSubstituteCPF());
        boolean retorno2 = candidateRepository.existsByHolderCPFAndSubstituteCPF(candidate.getHolderCPF(), candidate.getSubstituteCPF());

        if(retorno2 || retorno1){
            return 1;
        }

        CandidateEntity candidateEntity = new CandidateEntityBuilder()
                .withHolderCPF(candidate.getHolderCPF())
                .withHolderName(candidate.getHolderName())
                .withSubstituteCPF(candidate.getSubstituteCPF())
                .withSubstituteName(candidate.getSubstituteName())
                .build();

        candidateRepository.save(candidateEntity);

        return 0;
    }

}
