package com.woorifisa.seminar.service;

import com.woorifisa.seminar.dto.MemberInfo;
import com.woorifisa.seminar.dto.auth.LoginRequest;
import com.woorifisa.seminar.entity.Member;
import com.woorifisa.seminar.repository.MemberRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;

    public MemberInfo login(final LoginRequest loginRequest) {

        Member member = memberRepository.findByUsername(loginRequest.getUsername())
                                        .orElseThrow();

        if (!Objects.equals(member.getPassword(), loginRequest.getPassword())) {
            throw new IllegalArgumentException();
        }

        return MemberInfo.from(member);
    }

}
