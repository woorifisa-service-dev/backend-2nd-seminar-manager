package com.woorifisa.seminar.dto.result;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResultScoreResponse {
	private final Long teacherScore;
	private final Long mentorScore;
	private final Long othersScore;
	private final Long totalScore;
	
	private final Long teamMemberTotalScore;
	private final Double teamMemberAvgScore;

	public static ResultScoreResponse from(Long targetTeacherScore, Long targetMentorScore, Long targetStudentScore, Long targetTotalScore, Long targetTeamMemberTotalScore, Double targetTeamMemberAvgScore) {
		return new ResultScoreResponse(targetTeacherScore, targetMentorScore, targetStudentScore, targetTotalScore, targetTeamMemberTotalScore, targetTeamMemberAvgScore);
	}
}
