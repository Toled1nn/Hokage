package com.example.projectversion2.entity.builder;

import com.example.projectversion2.entity.DataVoteEntity;
import com.example.projectversion2.entity.VoteEntity;

public class VoteEntityBuilder {

    private boolean statusVote = false;
    private DataVoteEntity dataVoteEntity = new DataVoteEntityBuilder().build();

    public VoteEntityBuilder withStatusVote(boolean statusVote) {
        this.statusVote=statusVote;

        return this;
    }

    public VoteEntityBuilder withDataVoteEntity(DataVoteEntity dataVoteEntity) {
        this.dataVoteEntity = dataVoteEntity;

        return this;
    }

    public VoteEntity build() {
        return new VoteEntity(statusVote, dataVoteEntity);
    }
}
