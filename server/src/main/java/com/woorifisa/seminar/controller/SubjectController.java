package com.woorifisa.seminar.controller;

import com.woorifisa.seminar.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/classes/{classId}/seminars/{seminarTypeId}")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public String test(@PathVariable Long classId, @PathVariable Long seminarTypeId) {
        subjectService.test(classId, seminarTypeId);
        return "success";
    }

}
