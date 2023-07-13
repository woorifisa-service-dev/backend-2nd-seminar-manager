package com.woorifisa.seminar.controller;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import com.woorifisa.seminar.dto.MemberInfo;
import com.woorifisa.seminar.dto.auth.LoginRequest;
import com.woorifisa.seminar.dto.common.CommonResponse;
import com.woorifisa.seminar.service.AuthService;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<CommonResponse<MemberInfo>> login(
        @RequestBody @Validated LoginRequest loginRequest, HttpSession session, HttpServletResponse resp) {

        MemberInfo loginMember = authService.login(loginRequest);

        session.setAttribute(MemberInfo.KEY, loginMember);
        System.out.println("LOGIN SUCCESS");
        return CommonResponse.create(OK, loginMember);
    }

    public void foo(HttpSession session) {
        MemberInfo member = (MemberInfo) session.getAttribute(MemberInfo.KEY);
        if (member == null) {
            throw new IllegalArgumentException();
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<CommonResponse<Void>> logout(HttpSession session) {

        session.invalidate();
        System.out.println("LOGOUT SUCCESS");

        return CommonResponse.create(NO_CONTENT, null);
    }

}
