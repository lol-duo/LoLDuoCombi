package com.lolduo.duo.repository.gameInfo;

import com.lolduo.duo.entity.gameInfo.DoubleMatchEntity;
import com.lolduo.duo.entity.gameInfo.SoloMatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DoubleMatchRepository extends JpaRepository<DoubleMatchEntity, Long> {
    @Query(value ="select * from double_match where date = ?1 limit ?2,1000",nativeQuery = true)
    List<DoubleMatchEntity> findAllByDate(LocalDate localDate,Long start);
    @Query(value ="select count(*) from double_match where date =?1",nativeQuery = true)
    Optional<Long> findSizeByDate(LocalDate localdate);
    Optional<DoubleMatchEntity> findByPosition1AndPosition2AndChampionId1AndChampionId2AndMainRune1AndMainRune2(String position1,String position2,Long champion1,Long champion2,Long mainRune1,Long mainRune2);
}
