package com.woorifisa.seminar.entity;

import java.io.Serializable;
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
@Table(name = "teams")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Team {

    @EmbeddedId
    private Id id;

    @ManyToOne
    @JoinColumn(name = "member_no", nullable = false)
    @MapsId("memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "subject_no", nullable = false)
    @MapsId("subjectId")
    private Subject subject;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    static class Id implements Serializable {
        private Long memberId;
        private Long subjectId;
    }

}
