package com.woorifisa.seminar.dto.result;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class MemberIdAndName {

        private final Long id;
    private final String name;

}
