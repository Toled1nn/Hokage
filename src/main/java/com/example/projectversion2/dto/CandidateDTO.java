package com.example.projectversion2.dto;

public class CandidateDTO {
    private int id;
    private String holderName;
    private String holderCPF;
    private String substituteName;
    private String substituteCPF;

    public int getID() {
        return id;
    }

    public void setCode(int id) {
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
