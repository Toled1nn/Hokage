package com.example.projectversion2.entity.builder;

import com.example.projectversion2.entity.DataVoteEntity;

import java.time.LocalDateTime;

public class DataVoteEntityBuilder {

    private int numCandidate = 0;
    private int qtdVoting = 0;
    private LocalDateTime open = null;
    private LocalDateTime close = null;

    public DataVoteEntityBuilder withNumCandidate(int numCandidate) {
        this.numCandidate = numCandidate;

        return this;
    }

    public DataVoteEntityBuilder withQtdVoting(int qtdVoting) {
        this.qtdVoting = qtdVoting;

        return this;
    }

    public DataVoteEntityBuilder withOpen(LocalDateTime open) {
        this.open = open;

        return this;
    }

    public DataVoteEntityBuilder withClose(LocalDateTime close) {
        this.close = close;

        return this;
    }

    public DataVoteEntity build() {
        return new DataVoteEntity(numCandidate, qtdVoting, open, close);
    }
}
