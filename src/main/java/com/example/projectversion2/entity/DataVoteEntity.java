package com.example.projectversion2.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DataVoteEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Num_Candidate", nullable = false)
    private int numCandidate;

    @Column(name = "Qtd_Voting", nullable = false)
    private int qtdVoting;

    @Column(name = "Open_Time", nullable = true)
    private LocalDateTime open;

    @Column(name = "Close_Time", nullable = true)
    private LocalDateTime close;

    public DataVoteEntity() {}

    public DataVoteEntity(int numCandidate, int qtdVoting, LocalDateTime open, LocalDateTime close) {
        this.numCandidate = numCandidate;
        this.qtdVoting = qtdVoting;
        this.open = open;
        this.close = close;
    }

    public int getNumCandidate() {
        return numCandidate;
    }

    public void setNumCandidate(int numCandidate) {
        this.numCandidate = numCandidate;
    }

    public int getQtdVoting() {
        return qtdVoting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getOpen() {
        return open;
    }

    public void setOpen(LocalDateTime open) {
        this.open = open;
    }

    public LocalDateTime getClose() {
        return close;
    }

    public void setClose(LocalDateTime close) {
        this.close = close;
    }

    public void setQtdVoting(int qtdVoting) {
        this.qtdVoting = qtdVoting;
    }
}
