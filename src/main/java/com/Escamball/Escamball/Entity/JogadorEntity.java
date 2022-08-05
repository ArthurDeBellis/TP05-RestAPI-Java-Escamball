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

    //Pontuacao
    private int ataque;
    private int defesa;
    private int fisico;
    private int geral;

    //Posicao
    private String posicao;
    @ManyToOne
    private TimeEntity time;
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

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getFisico() {
        return fisico;
    }

    public void setFisico(int fisico) {
        this.fisico = fisico;
    }

    public int getGeral() {
        return geral;
    }

    public void setGeral() {
        this.geral = (ataque+defesa+fisico)/3;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
}
