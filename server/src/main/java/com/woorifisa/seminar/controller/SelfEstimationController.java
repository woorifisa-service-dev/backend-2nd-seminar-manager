package com.woorifisa.seminar.controller;

import com.woorifisa.seminar.dto.common.CommonResponse;
import com.woorifisa.seminar.dto.estimation.EstimationResponse;
import com.woorifisa.seminar.service.SelfEstimationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/estimation/self")
@RequiredArgsConstructor
public class SelfEstimationController {
    private final SelfEstimationService selfEstimationService;

    @GetMapping
    public ResponseEntity<CommonResponse<List<EstimationResponse>>> getItems() {

        List<EstimationResponse> list = selfEstimationService.findEstimationItemsByIsOtherIsFalseOrderByOrder();

        return CommonResponse.create(HttpStatus.OK, list);
    }


}
