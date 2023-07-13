package com.woorifisa.seminar.controller;

import static org.springframework.http.HttpStatus.*;

import com.woorifisa.seminar.dto.common.CommonResponse;
import com.woorifisa.seminar.dto.result.ResultInfoResponse;
import com.woorifisa.seminar.service.SubjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/classes/{classId}/seminars/{seminarTypeId}/top3")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public ResponseEntity<CommonResponse<List<ResultInfoResponse>>> test(@PathVariable Long classId, @PathVariable Long seminarTypeId) {
        List<ResultInfoResponse> top3Result = subjectService.retrieveTop3Information(classId, seminarTypeId);
        return CommonResponse.create(OK, top3Result);
    }

}
