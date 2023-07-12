package com.woorifisa.seminar.service;

import com.woorifisa.seminar.dto.estimation.EstimationResponse;
import com.woorifisa.seminar.entity.constant.EvaluationArea;
import com.woorifisa.seminar.repository.EstimationItemRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SelfEstimationService {
    private final EstimationItemRepository estimationItemRepository;

    public List<EstimationResponse> findEstimationItemsByIsOtherIsFalseOrderByOrder() {

        return estimationItemRepository.findEstimationItemsByEvaluationAreaOrderByOrder(EvaluationArea.자체참여도)
                                       .stream()
                                       .map(EstimationResponse::from)
                                       .collect(Collectors.toList());
    }
}
