package com.example.projectversion2.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AuditorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private UserEntity userEntity;

    @ManyToOne(optional = false)
    private CandidateVoteEntity candidateVoteEntity;

    @Column(name = "Time_Voting",nullable = false)
    private LocalDateTime timeVoting;

    public AuditorEntity(UserEntity userEntity, CandidateVoteEntity candidateVoteEntity, LocalDateTime timeVoting) {
        this.userEntity = userEntity;
        this.candidateVoteEntity = candidateVoteEntity;
        this.timeVoting = timeVoting;
    }

    public AuditorEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public LocalDateTime getTimeVoting() {
        return timeVoting;
    }

    public void setTimeVoting(LocalDateTime timeVoting) {
        this.timeVoting = timeVoting;
    }

    public CandidateVoteEntity getCandidateVoteEntity() {
        return candidateVoteEntity;
    }

    public void setCandidateVoteEntity(CandidateVoteEntity candidateVoteEntity) {
        this.candidateVoteEntity = candidateVoteEntity;
    }
}
