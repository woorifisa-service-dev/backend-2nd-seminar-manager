package com.woorifisa.seminar.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "team_estimation_items")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TeamEstimationItem {

    @EmbeddedId
    private TeamEstimationItem.Id id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_no")
    @MapsId("estimationItemId")
    private EstimationItem estimationItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_estimation_no")
    @MapsId("teamEstimationId")
    private TeamEstimation teamEstimation;

    @Column
    private Integer score;

    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    @Getter
    static class Id implements Serializable {

        private Long estimationItemId;
        private Long teamEstimationId;

    }

}
