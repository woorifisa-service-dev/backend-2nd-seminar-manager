package com.woorifisa.seminar.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "estimation_other_items")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OtherEstimationItem {

    @EmbeddedId
    private Id id;

    @ManyToOne
    @JoinColumn(name = "item_no")
    @MapsId("estimationItemId")
    private EstimationItem estimationItem;

    @ManyToOne
    @JoinColumn(name = "other_estimation_no")
    @MapsId("otherEstimationId")
    private OtherEstimation otherEstimation;

    @Column
    private Integer score;

    public OtherEstimationItem(EstimationItem estimationItem, OtherEstimation otherEstimation, Integer score) {
        this.id = new Id(estimationItem.getId(), otherEstimation.getId());
        this.estimationItem = estimationItem;
        this.otherEstimation = otherEstimation;
        this.score = score;
    }

    @NoArgsConstructor // 아무 인자 없는 생성자
    @EqualsAndHashCode // equals 랑 hashcode 메서드를 합쳐 놓은 건데, 동일성을 확인하려고 한다.
    @Embeddable
    @AllArgsConstructor
    @Getter
    public static class Id implements Serializable {
        private Long estimationItemId;
        private Long otherEstimationId;
    }

}
