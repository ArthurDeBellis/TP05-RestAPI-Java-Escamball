package com.Escamball.Escamball.Repository;

import com.Escamball.Escamball.Entity.JogadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadorRepository extends JpaRepository<JogadorEntity, Integer> {
    @Query("select max(j.jogadorId) from JogadorEntity j")
    Integer findMaxId();

    List<JogadorEntity> findAllByPosicao(String posicao);
}
