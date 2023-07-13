package com.woorifisa.seminar.dto.result;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Builder
@RequiredArgsConstructor
@Getter
@ToString
public class ResultInfoResponse2 {

    private final String clazzName;
    private final String seminarTypeName;
    private final Long subjectId;
    private final String subjectTitle;
    private final Integer subjectOrder;
    private final List<MemberIdAndName> memberList;

}
