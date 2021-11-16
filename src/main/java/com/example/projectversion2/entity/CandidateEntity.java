package com.example.projectversion2.entity;

import javax.persistence.*;

@Entity
public class CandidateEntity {

    @Id
    @Column(name = "IdCandidate", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CandidateName", nullable = false)
    private String holderName;

    @Column(name = "CandidateCPF", nullable = false)
    private String holderCPF;

    @Column(name = "SubstitutleName", nullable = false)
    private String substituteName;

    @Column(name = "SubstituteCPF", nullable = false)
    private String substituteCPF;

    public CandidateEntity() {}

    public CandidateEntity(String holderName, String holderCPF, String substituteName, String substituteCPF) {
        this.holderName = holderName;
        this.holderCPF = holderCPF;
        this.substituteName = substituteName;
        this.substituteCPF = substituteCPF;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getHolderCPF() {
        return holderCPF;
    }

    public void setHolderCPF(String holderCPF) {
        this.holderCPF = holderCPF;
    }

    public String getSubstituteName() {
        return substituteName;
    }

    public void setSubstituteName(String substituteName) {
        this.substituteName = substituteName;
    }

    public String getSubstituteCPF() {
        return substituteCPF;
    }

    public void setSubstituteCPF(String substituteCPF) {
        this.substituteCPF = substituteCPF;
    }
}
