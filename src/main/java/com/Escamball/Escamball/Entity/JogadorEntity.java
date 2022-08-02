package com.Escamball.Escamball.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Jogadores")
public class JogadorEntity {
    @Id
    private int jogadorId;
    private String nomeJogador;
    private int idadeJogador;
    private long precoJogador;
    @ManyToOne
    private TimeEntity time;

    /*
    * Posicao
    * Pontuacao
    * */

    public JogadorEntity() {
    }

    public int getJogadorId() {
        return jogadorId;
    }

    public void setJogadorId(int jogadorId) {
        this.jogadorId = jogadorId;
    }

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

    public TimeEntity getTime() {
        return time;
    }

    public void setTime(TimeEntity time) {
        this.time = time;
    }
}
