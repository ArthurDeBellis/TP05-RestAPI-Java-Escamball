package com.Escamball.Escamball.Service;

import com.Escamball.Escamball.Entity.TransacoesEntity;
import com.Escamball.Escamball.Repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String createTransacao(TransacoesEntity transacoes)
    {
        try
        {
            if(!transacaoRepository.existsByJogadorOferecidoId(transacoes.getJogadorOferecidoId())
            && !transacaoRepository.existsByJogadorDesejadoId(transacoes.getJogadorDesejadoId()))
            {
                transacoes.setTransacaoId(transacaoRepository.findMaxId()==null?1 : transacaoRepository.findMaxId()+1);
                transacoes.setTransacaoAceita(false);
                transacoes.setTransacaoFinalizada(false);
                transacaoRepository.save(transacoes);
                return "Transacao Registrada";
            }
            else{
                return "Esta transacao já foi registrada";
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
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
    public String rejeitaTransacao(int id)
    {
        TransacoesEntity t = findTransacaoById(id);
        if(t==null)
        {
            return "Transacao não encontrada!";
        }
        t.setTransacaoId(id);
        if(t.isTransacaoFinalizada())
        {
            t.setTransacaoFinalizada(true);
            t.setTransacaoAceita(false);
            transacaoRepository.save(t);
            return "Transacao recusada com sucesso!";
        }
        return "A transacao já foi finalizada!";
    }

    @Transactional
    public String aceitaTransacao(int id)
    {
        TransacoesEntity t = findTransacaoById(id);
        if(t==null)
        {
            return "Transacao não encontrada!";
        }
        t.setTransacaoId(id);
        if(t.isTransacaoFinalizada())
        {
            t.setTransacaoFinalizada(true);
            t.setTransacaoAceita(true);
            transacaoRepository.save(t);
            jogadorService.transfereTime(t.getJogadorDesejadoId(), t.getTimePropostaId());
            jogadorService.transfereTime(t.getJogadorOferecidoId(),t.getTimeReceptorId());
            return "Transacao aceita!";
        }
        return "A transacao já foi finalizada!";
    }

}
