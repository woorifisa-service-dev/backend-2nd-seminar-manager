package com.woorifisa.seminar.dto.estimation;

import com.woorifisa.seminar.entity.EstimationItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class EstimationResponse {

    private final String title;
    private final Integer maxScore;

    public static EstimationResponse from(EstimationItem item) {
        return new EstimationResponse(item.getTitle(), item.getMaxScore());
    }

}