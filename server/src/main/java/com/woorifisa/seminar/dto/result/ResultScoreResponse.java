package com.woorifisa.seminar.dto.result;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResultScoreResponse {
	private final Integer teacherScore;
	private final Integer mentorScore;
	private final Integer othersScore;
	private final Integer totalScore;
	private final Integer teamScore;

	public static ResultScoreResponse from() {
		return null;
	}
}
