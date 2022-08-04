package com.Escamball.Escamball.Controllers;

import com.Escamball.Escamball.Entity.JogadorEntity;
import com.Escamball.Escamball.Models.JogadorModel;
import com.Escamball.Escamball.Service.JogadorService;
import com.Escamball.Escamball.Service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/Jogador")
public class JogadorController {
    @Autowired
    JogadorService jogadorService;

    @GetMapping("/Jogadores")
    public List<JogadorEntity> listJogadores(){
        return jogadorService.findAllJogadores();
    }
    @GetMapping("/JogadorPorId/{jogadorId}")
    public JogadorEntity jogadorPorId(@PathVariable(value = "jogadorId") int jogadorId)
    {
        return jogadorService.findJogadorById(jogadorId);
    }

    @GetMapping("JogadoresPorNome/{nomeJogador}")
    public List<JogadorEntity> jogadoresPorNome(@PathVariable(value = "nomeJogador") String nomeJogador)
    {
        return jogadorService.findJogadoresByNome(nomeJogador);
    }

    @GetMapping("JogadoresPorIdTime/{timeId}")
    public List<JogadorEntity> jogadoresPorIdTime(@PathVariable(value = "timeId") int timeId )
    {
        return jogadorService.findElenco(timeId);
    }

    @PostMapping("/InsereJogador")
    public String novoJogador(@RequestBody JogadorModel jogadorModel){
        return jogadorService.createJogador(jogadorModel);
    }
}
