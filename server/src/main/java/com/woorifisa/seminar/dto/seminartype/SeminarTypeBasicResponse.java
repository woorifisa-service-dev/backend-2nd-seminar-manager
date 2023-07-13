package com.woorifisa.seminar.dto.seminartype;

import com.woorifisa.seminar.entity.SeminarType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SeminarTypeBasicResponse {

    private final Long id;
    private final String title;

    public static SeminarTypeBasicResponse from(SeminarType seminarType) {
        return new SeminarTypeBasicResponse(seminarType.getId(), seminarType.getName());
    }

}
