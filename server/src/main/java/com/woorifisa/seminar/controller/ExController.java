package com.woorifisa.seminar.controller;

import com.woorifisa.seminar.dto.MemberInfo;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy-login")
public class ExController {

    @GetMapping
    public MemberInfo dummyLogin(HttpSession session) {

        MemberInfo dummy = (MemberInfo) session.getAttribute(MemberInfo.KEY);

        return dummy;
    }
}
