package com.Escamball.Escamball.Repository;

import com.Escamball.Escamball.Entity.TimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<TimeEntity, Integer> {

    boolean existsByLogin(String Login);

    @Query ("select max(t.timeId) from TimeEntity t")
    Integer findMaxId();


}
