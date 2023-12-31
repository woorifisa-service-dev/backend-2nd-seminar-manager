package com.woorifisa.seminar.entity;

import com.woorifisa.seminar.entity.constant.EvaluationArea;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estimation_items")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EstimationItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_no")
	private Long id;

	@Column(nullable = false, length = 500)
	private String title;

	@Column(name = "max_score", nullable = false)
	private Integer maxScore;

	@Column(nullable = false)
	private Integer order;

	@Column(name = "evaluation_area", nullable = false)
	@Enumerated(EnumType.STRING)
	private EvaluationArea evaluationArea;

}
