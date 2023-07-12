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
	private final String subjectTitle;
	private final Integer subjectOrder;
	private final List<String> memberNameList;
	
	public static ResultInfoResponse from(String clazzName, String seminarTypeName, String subjectTitle, Integer subjectOrder, List<String> memberNameList) {
		return new ResultInfoResponse(clazzName, seminarTypeName, subjectTitle, subjectOrder, memberNameList);
	}
}
