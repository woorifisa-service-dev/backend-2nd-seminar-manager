package com.woorifisa.seminar.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class MemberInfo {

    public static final String KEY = "MEMBER";

    private final Long id;
    private final String username;
    private final String name;
    private final String email;

    public static MemberInfo getDummy() {
        return new MemberInfo(2L, "sunjoo", "양선주", "sunjoo@gmail.com");
    }

}
