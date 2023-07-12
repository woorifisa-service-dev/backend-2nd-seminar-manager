package com.woorifisa.seminar.controller;

import com.woorifisa.seminar.dto.MemberInfo;
import com.woorifisa.seminar.dto.common.CommonResponse;
import com.woorifisa.seminar.dto.estimation.EstimationResponse;
import com.woorifisa.seminar.dto.estimation.otherEstimation.request.OtherEstimationRequest;
import com.woorifisa.seminar.service.OtherEstimationService;
import java.util.List;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estimation/other")
@RequiredArgsConstructor
public class OtherEstimationController {

    private final OtherEstimationService otherEstimationService;

    @GetMapping
    public ResponseEntity<CommonResponse<List<EstimationResponse>>> retrieveOtherEstimationItems() {

        List<EstimationResponse> estimationItems = otherEstimationService.findEstimationItems();

        return CommonResponse.create(HttpStatus.OK, estimationItems);
    }

    @PostMapping("/{subjectNo}")
    public ResponseEntity<CommonResponse<List<EstimationResponse>>> estimateOtherTeam(
        HttpSession session, @PathVariable Long subjectNo,
        @Validated @RequestBody OtherEstimationRequest otherEstimationRequest) {

        MemberInfo member = (MemberInfo) session.getAttribute(MemberInfo.KEY);
        List<EstimationResponse> estimationResponses =
            otherEstimationService.estimateOtherTeamByStudent(subjectNo, member, otherEstimationRequest);


        return CommonResponse.create(HttpStatus.CREATED, estimationResponses);
    }

}
