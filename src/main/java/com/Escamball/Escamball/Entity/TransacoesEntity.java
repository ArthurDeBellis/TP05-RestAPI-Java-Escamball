package com.Escamball.Escamball.Entity;

import javax.persistence.*;

@Entity
@Table(name="Transacoes")
public class TransacoesEntity {
    @Id
    private int transacaoId;

    private int timePropostaId;
    private int timeReceptorid;

    private int jogadorOferecidoId;
    private int jogadorDesejadoId;

    public TransacoesEntity() {  }

    public int getTransacaoId() {
        return transacaoId;
    }

    public void setTransacaoId(int transacaoId) {
        this.transacaoId = transacaoId;
    }

    public int getTimePropostaId() {
        return timePropostaId;
    }

    public void setTimePropostaId(int timePropostaId) {
        this.timePropostaId = timePropostaId;
    }

    public int getTimeReceptorid() {
        return timeReceptorid;
    }

    public void setTimeReceptorid(int timeReceptorid) {
        this.timeReceptorid = timeReceptorid;
    }

    public int getJogadorOferecidoId() {
        return jogadorOferecidoId;
    }

    public void setJogadorOferecidoId(int jogadorOferecidoId) {
        this.jogadorOferecidoId = jogadorOferecidoId;
    }

    public int getJogadorDesejadoId() {
        return jogadorDesejadoId;
    }

    public void setJogadorDesejadoId(int jogadorDesejadoId) {
        this.jogadorDesejadoId = jogadorDesejadoId;
    }
}
