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
	@JoinColumn(nullable = false, name = "member_no")
	private Member member;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "subject_no")
	private Subject subject;
}
