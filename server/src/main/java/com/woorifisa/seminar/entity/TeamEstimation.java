package com.woorifisa.seminar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estimation_teams")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TeamEstimation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_estimation_no")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_no", nullable = false)
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no", nullable = false)
    private Member member;

    @Column(name = "target_member_no", nullable = false)
    private Long targetMemberNo;

    public TeamEstimation(Subject subject, Member member, Long targetMemberNo) {
        this.subject = subject;
        this.member = member;
        this.targetMemberNo = targetMemberNo;
    }
}
