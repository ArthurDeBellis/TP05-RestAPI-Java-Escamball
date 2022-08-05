package com.Escamball.Escamball.Service;

import com.Escamball.Escamball.Entity.JogadorEntity;
import com.Escamball.Escamball.Entity.TransacoesEntity;
import com.Escamball.Escamball.Repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private JogadorService jogadorService;

    @Transactional
    public ResponseEntity<TransacoesEntity> createTransacao(TransacoesEntity transacoes)
    {

        JogadorEntity jogadorOferecido = jogadorService.findJogadorById(transacoes.getJogadorOferecidoId());
        JogadorEntity jogadorDesejado = jogadorService.findJogadorById(transacoes.getJogadorDesejadoId());

        if(jogadorOferecido == null
                || jogadorOferecido.getTime() == null
                || jogadorOferecido.getTime().getTimeId() != transacoes.getTimePropostaId()
        ){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        if(jogadorDesejado == null
                || jogadorDesejado.getTime() == null
                || jogadorDesejado.getTime().getTimeId() != transacoes.getTimeReceptorId()
        ){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        transacoes.setTransacaoId(transacaoRepository.findMaxId()==null?1 : transacaoRepository.findMaxId()+1);
        transacoes.setTransacaoAceita(false);
        transacoes.setTransacaoFinalizada(false);
        transacaoRepository.save(transacoes);
        return new ResponseEntity<>(transacoes, HttpStatus.OK);
    }

    public List<TransacoesEntity> findAllTransacoes()
    {
        return transacaoRepository.findAll();
    }

    public TransacoesEntity findTransacaoById(int transacaoId)
    {
        Optional<TransacoesEntity> t = transacaoRepository.findById(transacaoId);
        return t.orElse(null);
    }

    public List<TransacoesEntity> findAllTransacoesByTimeReceptorId(int timeReceptorId)
    {
        return transacaoRepository.findAllByTimeReceptorId(timeReceptorId);
    }

    @Transactional
    public ResponseEntity<TransacoesEntity> rejeitaTransacao(int id)
    {
        TransacoesEntity t = findTransacaoById(id);
        if(t==null)
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        t.setTransacaoId(id);
        if(!t.isTransacaoFinalizada())
        {
            t.setTransacaoFinalizada(true);
            t.setTransacaoAceita(false);
            transacaoRepository.save(t);
            return new ResponseEntity<>(t, HttpStatus.OK);

        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Transactional
    public ResponseEntity<TransacoesEntity> aceitaTransacao(int id)
    {
        TransacoesEntity t = findTransacaoById(id);
        if(t==null)
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        t.setTransacaoId(id);
        if(!t.isTransacaoFinalizada())
        {
            t.setTransacaoFinalizada(true);
            t.setTransacaoAceita(true);
            transacaoRepository.save(t);
            jogadorService.transfereTime(t.getJogadorDesejadoId(), t.getTimePropostaId());
            jogadorService.transfereTime(t.getJogadorOferecidoId(),t.getTimeReceptorId());
            return new ResponseEntity<>(t, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}
