package com.Escamball.Escamball.Service;

import com.Escamball.Escamball.Entity.JogadorEntity;
import com.Escamball.Escamball.Entity.TimeEntity;
import com.Escamball.Escamball.Models.JogadorModel;
import com.Escamball.Escamball.Repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {
    @Autowired
    private JogadorRepository jogadorRepository;
    @Transactional
    public String createJogador(JogadorModel jogador) {
        JogadorEntity j = new JogadorEntity();
        j.setJogadorId(jogadorRepository.findMaxId()==null ? 1 : jogadorRepository.findMaxId()+1);
        j.setNomeJogador(jogador.getNomeJogador());
        j.setIdadeJogador(jogador.getIdadeJogador());
        j.setPrecoJogador(jogador.getPrecoJogador());

        j.setAtaque(jogador.getAtaque());
        j.setDefesa(jogador.getDefesa());
        j.setFisico(jogador.getFisico());

        j.setGeral();

        j.setPosicao(jogador.getPosicao().toUpperCase());

        TimeEntity refTime = new TimeEntity();
        refTime.setTimeId(jogador.getTimeId());
        j.setTime(refTime);
        jogadorRepository.save(j);
        return "Jogador cadastrado";
    }

    public List<JogadorEntity> findAllJogadores(){
        return jogadorRepository.findAll();
    }
    public JogadorEntity findJogadorById(int jogadorId){
        Optional<JogadorEntity> j = jogadorRepository.findById(jogadorId);
        return j.orElse(null);
    }
    public List<JogadorEntity> findJogadoresByNome(String nomeJogador)
    {
        List<JogadorEntity> retorno = new ArrayList<>();
        List<JogadorEntity> jogadores = jogadorRepository.findAll();
        for(JogadorEntity j:jogadores ) {
            if(j.getNomeJogador().toLowerCase().contains(nomeJogador.toLowerCase())){
                retorno.add(j);
            }
        }
        return retorno;
    }

    public List<JogadorEntity> findJogadoresByPosicao(String posicao)
    {
        return jogadorRepository.findAllByPosicao(posicao);
    }

    public List<JogadorEntity> findElenco(int idTime){
        List<JogadorEntity> retorno = new ArrayList<>();
        List<JogadorEntity> jogadores = jogadorRepository.findAll();
        for(JogadorEntity j:jogadores ) {
            if(j.getTime().getTimeId() == idTime){
                retorno.add(j);
            }
        }
        return retorno;
    }

    @Transactional
    public String updateJogador(int jogadorId, JogadorEntity jogador){
        if(jogadorRepository.existsById(jogadorId)){
            JogadorEntity j = findJogadorById(jogadorId);
            j.setJogadorId(jogadorId);
            if(!jogador.getNomeJogador().equals("")){
                j.setNomeJogador(jogador.getNomeJogador());
            }
            jogadorRepository.save(j);
            return "Jogador Atualizado";
        }
        else{
            return "Jogador não Encontrado";
        }
    }

    @Transactional
    public String deleteJogador(int jogadorId){
        if (jogadorRepository.existsById(jogadorId)){
            JogadorEntity j = findJogadorById(jogadorId);
            jogadorRepository.delete(j);
            return "Jogador deletado.";
        }else {
            return "Jogador não encontrado";
        }
    }

    @Transactional
    public String transfereTime(int jogadorId, int timeId)
    {
        if(jogadorRepository.existsById(jogadorId))
        {
            JogadorEntity j = findJogadorById(jogadorId);
            j.setJogadorId(jogadorId);
            TimeEntity refTime = new TimeEntity();
            refTime.setTimeId(timeId);
            j.setTime(refTime);
            jogadorRepository.save(j);
            return "Transferência feita";
        }
        return "Jogador não encontrado";
    }
}
