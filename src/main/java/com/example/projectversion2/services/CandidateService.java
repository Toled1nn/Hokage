package com.example.projectversion2.services;

import com.example.projectversion2.dto.CandidateDTO;
import com.example.projectversion2.dto.VoteDTO;
import com.example.projectversion2.entity.CandidateEntity;

import java.util.ArrayList;
import java.util.List;

//Todo: Transforma Repositórios dos Candidatos em DTOs dos Candidatos;

//TODO: Verificar os parâmetros vindo da herança


public class CandidateService {
   /*
    private CandidateRepository cand_repo;

    public List<CandidateDTO> getCandidate(VoteDTO voto){
        List<CandidateDTO> res = new ArrayList<>();

        List<CandidateEntity> cand_entity = cand_repo.getCandidate();

        for (int i=0;i<cand_entity.size();i++){
            CandidateEntity temp = cand_entity.get(i);
            CandidateDTO dto = new CandidateDTO();
            dto.setCode(temp.getCode());
            dto.setHolder_name(temp.getHolder_name());
            dto.setSubstitute_name(temp.getSubstitute_name());

            res.add(dto);
        }
        return res;
    }

    */
}
