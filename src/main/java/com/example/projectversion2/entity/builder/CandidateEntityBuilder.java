package com.example.projectversion2.entity.builder;

import com.example.projectversion2.entity.CandidateEntity;

public class CandidateEntityBuilder {

    private String holderName;
    private String holderCPF;
    private String substituteName;
    private String substituteCPF;

    public CandidateEntityBuilder() {
    }

    public CandidateEntityBuilder withHolderName(String holderName) {
        this.holderName = holderName;

        return this;
    }

    public CandidateEntityBuilder withHolderCPF(String holderCPF) {
        this.holderCPF = holderCPF;

        return this;
    }

    public CandidateEntityBuilder withSubstituteName(String substituteName) {
        this.substituteName = substituteName;

        return this;
    }

    public CandidateEntityBuilder withSubstituteCPF(String substituteCPF) {
        this.substituteCPF = substituteCPF;

        return this;
    }

    public CandidateEntity build() {
        return new CandidateEntity(holderName, holderCPF, substituteName, substituteCPF);
    }
}
