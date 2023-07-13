package com.woorifisa.seminar.dto.subject;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Top3Result {

    private final Long subjectId;
    private final String title;
    private final Long totalScore;

}
