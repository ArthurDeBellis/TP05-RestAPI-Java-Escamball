package com.Escamball.Escamball.Controllers;

import com.Escamball.Escamball.Entity.TransacoesEntity;
import com.Escamball.Escamball.Models.TransacaoModel;
import com.Escamball.Escamball.Service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/Transacao")
public class TransacaoController {
    @Autowired
    TransacaoService transacaoService;

    @GetMapping("/Transacoes")
    public List<TransacoesEntity> listTransacoes()
    {
        return transacaoService.findAllTransacoes();
    }

    @GetMapping("/GetTransacaoPorId/{transacaoId}")
    public TransacoesEntity getTransacaoPorId (@PathVariable(value = "transacaoId") int transacaoId)
    {
        return transacaoService.findTransacaoById(transacaoId);
    }

    @GetMapping("GetTransacoesPorTimeId/{timeId}")
    public List<TransacoesEntity> getTransacoesPorTimeId(@PathVariable(value = "timeId") int timeId)
    {
        return transacaoService.findAllTransacoesByTimeReceptorId(timeId);
    }

    @PostMapping("InsereTransacao")
    public ResponseEntity<TransacoesEntity> novaTransacao(@RequestBody TransacoesEntity transacoesEntity)
    {
        return transacaoService.createTransacao(transacoesEntity);
    }

    @PutMapping("RecusaTransacao")
    public ResponseEntity<TransacoesEntity> recusaTransacao(@RequestBody TransacaoModel transacaoModel)
    {
        return transacaoService.rejeitaTransacao(transacaoModel.getTransacaoId());
    }

    @PutMapping("AceitaTransacao")
    public ResponseEntity<TransacoesEntity> aceitaTransacao(@RequestBody TransacaoModel transacaoModel)
    {
        return transacaoService.aceitaTransacao(transacaoModel.getTransacaoId());
    }
}
