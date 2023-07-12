package com.woorifisa.seminar.controller;

import com.woorifisa.seminar.dto.MemberInfo;
import com.woorifisa.seminar.dto.common.CommonResponse;
import com.woorifisa.seminar.dto.estimation.EstimationRequest;
import com.woorifisa.seminar.dto.estimation.EstimationResponse;
import com.woorifisa.seminar.service.SelfEstimationService;
import java.util.List;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/estimations/teams")
@RequiredArgsConstructor
public class TeamEstimationController {

    private final SelfEstimationService selfEstimationService;

    @GetMapping
    public ResponseEntity<CommonResponse<List<EstimationResponse>>> getItems() {

        List<EstimationResponse> list = selfEstimationService.findEstimationItems();

        return CommonResponse.create(HttpStatus.OK, list);
    }

    @PostMapping("/{targetMemberId}/subjects/{subjectNo}")
    public ResponseEntity<CommonResponse<List<EstimationResponse>>> estimateTeam(HttpSession session,
                                                                                 @PathVariable Long targetMemberId,
                                                                                 @PathVariable Long subjectNo,
                                                                                 @Validated @RequestBody
                                                                                 List<EstimationRequest> estimations) {
        MemberInfo member = (MemberInfo) session.getAttribute(MemberInfo.KEY);
        List<EstimationResponse> estimationResponses =
            selfEstimationService.estimateTeam(targetMemberId, subjectNo, member, estimations);


        return CommonResponse.create(HttpStatus.CREATED, estimationResponses);
    }


}
