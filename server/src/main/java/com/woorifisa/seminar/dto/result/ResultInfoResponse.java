package com.woorifisa.seminar.dto.result;

import java.util.List;

import com.woorifisa.seminar.entity.Clazz;
import com.woorifisa.seminar.entity.Member;
import com.woorifisa.seminar.entity.SeminarType;
import com.woorifisa.seminar.entity.Subject;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResultInfoResponse {
	
	private final String clazzName;
	private final String seminarTypeName;
	private final Long subjectId;
	private final String subjectTitle;
	private final Integer subjectOrder;
	private final List<Long> memberIdList;
	private final List<String> memberNameList;
	
	
	public static ResultInfoResponse from(String clazzName, String seminarTypeName, Long subjectId, String subjectTitle, Integer subjectOrder, List<Long> memberIdList, List<String> memberNameList) {
		return new ResultInfoResponse(clazzName, seminarTypeName, subjectId, subjectTitle, subjectOrder, memberIdList, memberNameList);
	}
}
