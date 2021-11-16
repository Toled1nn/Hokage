package com.example.projectversion2.dto;

public class ResultDTO {
    private int total_votos;
    private int votos_candidato1;
    private int votos_candidato2;
    private int resultado;

    public int getTotal_votos() {
        return total_votos;
    }

    public void setTotal_votos(int total_votos) {
        this.total_votos = total_votos;
    }

    public int getVotos_candidato1() {
        return votos_candidato1;
    }

    public void setVotos_candidato1(int votos_candidato1) {
        this.votos_candidato1 = votos_candidato1;
    }

    public int getVotos_candidato2() {
        return votos_candidato2;
    }

    public void setVotos_candidato2(int votos_candidato2) {
        this.votos_candidato2 = votos_candidato2;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
