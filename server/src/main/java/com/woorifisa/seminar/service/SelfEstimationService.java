package com.woorifisa.seminar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.woorifisa.seminar.dto.estimation.EstimationResponse;
import com.woorifisa.seminar.entity.EstimationItem;
import com.woorifisa.seminar.repository.EstimationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SelfEstimationService {
	private final EstimationRepository estimationRepository;
	
	public List<EstimationResponse> findEstimationItemsByIsOtherIsFalseOrderByOrder() {
		
		List<EstimationItem> itemList= estimationRepository.findEstimationItemsByIsOtherIsFalseOrderByOrder();
		
		
		return itemList.stream().map(EstimationResponse::from).collect(Collectors.toList());
		
	}
}
