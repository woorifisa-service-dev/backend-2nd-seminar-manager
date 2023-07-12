package com.woorifisa.seminar.dto;

import com.woorifisa.seminar.entity.Member;
import com.woorifisa.seminar.entity.constant.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@Builder
public class MemberInfo {

    public static final String KEY = "LOGIN_SESSION_KEY";

    private final Long id;
    private final String username;
    private final String name;
    private final String email;
    private final Type role;

    public static MemberInfo getDummy() {
        return new MemberInfo(2L, "sunjoo", "양선주", "sunjoo@gmail.com", Type.STUDENT);
    }

    public static MemberInfo from(Member member) {
        return MemberInfo.builder()
                         .id(member.getId())
                         .username(member.getUsername())
                         .name(member.getName())
                         .email(member.getEmail())
                         .role(member.getRole().getName())
                         .build();
    }
}
