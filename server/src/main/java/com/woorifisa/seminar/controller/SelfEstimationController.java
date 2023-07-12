package com.woorifisa.seminar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woorifisa.seminar.dto.MemberInfo;
import com.woorifisa.seminar.dto.common.CommonResponse;
import com.woorifisa.seminar.dto.estimation.EstimationResponse;
import com.woorifisa.seminar.entity.EstimationItem;
import com.woorifisa.seminar.service.SelfEstimationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/estimation/self")
@RequiredArgsConstructor
public class SelfEstimationController {
	private final SelfEstimationService selfEstimationService;
	
	@GetMapping
	public ResponseEntity<CommonResponse<List<EstimationResponse>>> getItems(HttpSession session){
		MemberInfo dummy = (MemberInfo) session.getAttribute(MemberInfo.KEY);
		
		return CommonResponse.create(HttpStatus.OK, selfEstimationService.findEstimationItemsByIsOtherIsFalseOrderByOrder());
	}
	
	
}
