package com.Escamball.Escamball.Repository;

import com.Escamball.Escamball.Entity.TransacoesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<TransacoesEntity, Integer>
{
    @Query("select max(t.transacaoId) from TransacoesEntity t")
    Integer findMaxId();
    List<TransacoesEntity> findAllByTimeReceptorId(int timeReceptorId);
    boolean existsByJogadorOferecidoId(int jogadorOferecidoId);
    boolean existsByJogadorDesejadoId(int jogadorDesejadoId);
}
