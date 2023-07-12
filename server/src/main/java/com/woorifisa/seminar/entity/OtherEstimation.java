package com.woorifisa.seminar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="estimation_others")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OtherEstimation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="other_estimation_no")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "member_no", nullable = false)
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "subject_no", nullable = false)
	private Subject subject;

	public OtherEstimation(Member member, Subject subject) {
		this.member = member;
		this.subject = subject;
	}

}
