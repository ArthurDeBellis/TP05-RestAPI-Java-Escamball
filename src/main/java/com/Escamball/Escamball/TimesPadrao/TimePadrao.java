package com.Escamball.Escamball.TimesPadrao;

import com.Escamball.Escamball.Entity.TimeEntity;

public class TimePadrao {
    TimeEntity timeArthur;
    TimeEntity timeSaulo;

    public TimePadrao() {
        timeArthur = preencheTimeArthur();
        timeSaulo = preencheTimeSaulo();
    }

    private TimeEntity preencheTimeArthur(){
        TimeEntity real = new TimeEntity();
        real.setNomeDono("Arthur");
        real.setNomeTime("Real");
        real.setLogin("arthur");
        real.setSenha("3503");
        return real;
    }

    private TimeEntity preencheTimeSaulo(){
        TimeEntity psg = new TimeEntity();
        psg.setNomeDono("Saulo");
        psg.setNomeTime("PSG");
        psg.setLogin("saulo");
        psg.setSenha("3475");
        return psg;
    }

    public TimeEntity getTimeArthur() {
        return timeArthur;
    }

    public TimeEntity getTimeSaulo() {
        return timeSaulo;
    }
}
