package com.example.projectversion2.entity;

import javax.persistence.*;

@Entity
public class VoteEntity {

    @Id
    @Column(name = "ID_Vote",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_vote;
    @Column(name = "Status_Vote",nullable = false)
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "data_id", referencedColumnName = "id")
    private DataVoteEntity dataVoteEntity;

    public VoteEntity() {}

    public VoteEntity(boolean status, DataVoteEntity dataVoteEntity) {
        this.status = status;
        this.dataVoteEntity = dataVoteEntity;
    }

    public int getID_vote() {
        return ID_vote;
    }

    public void setID_vote(int ID_vote) {
        this.ID_vote = ID_vote;
    }

    public boolean isStatus() {
        return status;
    }

    public DataVoteEntity getDataVoteEntity() {
        return dataVoteEntity;
    }

    public void setDataVoteEntity(DataVoteEntity dataVoteEntity) {
        this.dataVoteEntity = dataVoteEntity;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
