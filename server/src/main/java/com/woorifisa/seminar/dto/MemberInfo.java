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
        // return new MemberInfo(21L, "minsung", "정민성", "minsung@gmail.com", Type.STUDENT);
    }

    public static MemberInfo getDummyMentor() {
        return new MemberInfo(29L, "mentor", "멘토", "mentor@gmail.com", Type.MENTOR);
    }

    public static MemberInfo getDummyTeacher() {
        return new MemberInfo(28L, "jungho", "유정호", "jungho@gmail.com", Type.TEACHER);
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
