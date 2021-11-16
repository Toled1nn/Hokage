package com.example.projectversion2.services;

//todo: Serviço de cadastro de Eleição
import com.example.projectversion2.entity.VoteEntity;
import com.example.projectversion2.entity.builder.VoteEntityBuilder;
import com.example.projectversion2.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("singleton")
public class AuthVoteService {

    @Autowired
    private VoteRepository voteRepository;

    public int register() {

        VoteEntity voteEntity = new VoteEntityBuilder().build();
        voteRepository.save(voteEntity);

        return 0;
    }
}
