package com.Escamball.Escamball.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Times")
public class TimeEntity {
    @Id
    private int timeId;
    private String nomeDono;
    private String nomeTime;
    private String login;
    private String senha;
    //private List<JogadorModel> Elenco;

    public TimeEntity () { }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + timeId +
                ", Nome Dono='" + nomeDono + '\'' +
                ", Nome Time='" + nomeTime + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
