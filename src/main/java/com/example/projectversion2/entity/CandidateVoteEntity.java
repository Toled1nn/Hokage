package com.example.projectversion2.entity;

import javax.persistence.*;

@Entity
public class CandidateVoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    private VoteEntity voteEntity;

    @ManyToOne(optional = false)
    private CandidateEntity candidateEntity;

    public CandidateVoteEntity(VoteEntity voteEntity, CandidateEntity candidateEntity) {
        this.voteEntity = voteEntity;
        this.candidateEntity = candidateEntity;
    }

    public CandidateVoteEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VoteEntity getVoteEntity() {
        return voteEntity;
    }

    public void setVoteEntity(VoteEntity voteEntity) {
        this.voteEntity = voteEntity;
    }

    public CandidateEntity getCandidateEntity() {
        return candidateEntity;
    }

    public void setCandidateEntity(CandidateEntity candidateEntity) {
        this.candidateEntity = candidateEntity;
    }
}
