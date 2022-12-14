package com.lolduo.duo.v2.entity.gameInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "double_match",indexes = {
        @Index(name="all_count_index",columnList = "all_count"),
        @Index(name="date_index",columnList = "date"),
        @Index(name="multi_index",columnList = "position1,position2, champion_id1,champion_id2,main_rune1,main_rune2",unique = true),
        @Index(name="double_match_index",columnList = "all_count,win_rate desc, position1, champion_id1,position2,champion_id2")})
public class DoubleMatchEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "position1")
    private String position1;
    @Column(name = "position2")
    private String position2;
    @Column(name = "champion_id1")
    private Long championId1;
    @Column(name = "champion_id2")
    private Long championId2;
    @Column(name = "main_rune1")
    private Long mainRune1;
    @Column(name = "main_rune2")
    private Long mainRune2;

    @Column(name = "all_count")
    private Long allCount;
    @Column(name = "win_count")
    private Long winCount;
    @Column(name = "win_rate")
    private Double winRate;

    @Column(name = "comb_id1")
    private Long combId1;
    @Column(name = "comb_id2")
    private Long combId2;

    public void setAllCount(Long allCount) {
        this.allCount = allCount;
    }

    public void setWinCount(Long winCount) {
        this.winCount = winCount;
    }

    public void setWinRate(Double winRate) {
        this.winRate = winRate;
    }

    public DoubleMatchEntity(LocalDate date, String position1, String position2, Long championId1, Long championId2, Long mainRune1, Long mainRune2, Long allCount, Long winCount, Double winRate, Long combId1, Long combId2) {
        this.date = date;
        this.position1 = position1;
        this.position2 = position2;
        this.championId1 = championId1;
        this.championId2 = championId2;
        this.mainRune1 = mainRune1;
        this.mainRune2 = mainRune2;
        this.allCount = allCount;
        this.winCount = winCount;
        this.winRate = winRate;
        this.combId1 = combId1;
        this.combId2 = combId2;
    }
}
