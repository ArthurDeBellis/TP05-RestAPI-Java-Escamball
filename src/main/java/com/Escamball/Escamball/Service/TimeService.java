package com.Escamball.Escamball.Service;

import com.Escamball.Escamball.Entity.TimeEntity;
import com.Escamball.Escamball.LightModel.TimeLightModel;
import com.Escamball.Escamball.Repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    @Transactional
    public String createTime(TimeEntity time){
        try{
            if(!timeRepository.existsByLogin(time.getLogin())){
                time.setTimeId(null == timeRepository.findMaxId()?1 : timeRepository.findMaxId() + 1);
                timeRepository.save(time);
                return "Time registrado";
            }else{
                return "Este login já foi cadastrado!";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<TimeEntity> findAllTimes(){
        return timeRepository.findAll();
    }

    public TimeEntity findTimeById(int id){
        return timeRepository.findById(id).isPresent()? timeRepository.findById(id).get() : new TimeEntity();
    }

    @Transactional
    public String updateTime(int timeId, TimeLightModel time){
        if (timeRepository.existsById(timeId)){
            try {
                TimeEntity timeSelecionado = findTimeById(timeId);
                timeSelecionado.setTimeId(timeId);
                if(!time.getNomeDono().equals("")){
                    timeSelecionado.setNomeDono(time.getNomeDono());
                }
                if(!time.getNomeTime().equals("")){
                    timeSelecionado.setNomeTime(time.getNomeTime());
                }
                if(!time.getLogin().equals("")){
                    timeSelecionado.setLogin(time.getLogin());
                }
                timeRepository.save(timeSelecionado);

                return "Time atualizado";
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else {
            return "Time não encontrado.";
        }
    }

    @Transactional
    public String deleteTime(int id){
        if (timeRepository.existsById(id)){
            try {
                TimeEntity timeDeletado = findTimeById(id);
                timeRepository.delete(timeDeletado);
                return "Time deletado.";
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else {
            return "Time não encontrado";
        }
    }

}
