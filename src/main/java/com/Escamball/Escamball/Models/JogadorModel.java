package com.Escamball.Escamball.Models;

public class JogadorModel {
    private String nomeJogador;
    private int idadeJogador;
    private long precoJogador;
    private int timeId;

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getIdadeJogador() {
        return idadeJogador;
    }

    public void setIdadeJogador(int idadeJogador) {
        this.idadeJogador = idadeJogador;
    }

    public long getPrecoJogador() {
        return precoJogador;
    }

    public void setPrecoJogador(long precoJogador) {
        this.precoJogador = precoJogador;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }
}
