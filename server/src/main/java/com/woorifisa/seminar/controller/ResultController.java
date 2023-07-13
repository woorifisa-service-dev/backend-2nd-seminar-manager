package com.woorifisa.seminar.controller;

import com.woorifisa.seminar.dto.common.CommonResponse;
import com.woorifisa.seminar.dto.result.ResultInfoResponse;
import com.woorifisa.seminar.dto.result.ResultScoreResponse;
import com.woorifisa.seminar.service.ResultService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/estimation/result")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;

    @GetMapping(path = "/classes/{classId}/seminars/{seminarTypeId}")
    public ResponseEntity<CommonResponse<List<ResultInfoResponse>>> getResultInfo(@PathVariable Long classId,
                                                                                  @PathVariable Long seminarTypeId) {
        List<ResultInfoResponse> allResultInfo = resultService.getAllResultInfo(classId, seminarTypeId);
        return CommonResponse.create(HttpStatus.OK, allResultInfo);
    }

    //	@GetMapping(path="/classes/{classId}/{seminarTypeId}/top3")
//	public ResponseEntity<T> getResultTop3Info(@PathVariable Long classId, @PathVariable Long seminarTypeId){
//		
//	}
//	
    @GetMapping(path = "/score/classes/{classId}/seminars/{seminarTypeId}/subjects/{subjectId}/members/{memberId}")
    public ResponseEntity<CommonResponse<ResultScoreResponse>> getResultScore(@PathVariable Long subjectId,
                                                                              @PathVariable Long memberId) {

        return CommonResponse.create(HttpStatus.OK, resultService.getScoreByUser(memberId, subjectId));
    }
}
