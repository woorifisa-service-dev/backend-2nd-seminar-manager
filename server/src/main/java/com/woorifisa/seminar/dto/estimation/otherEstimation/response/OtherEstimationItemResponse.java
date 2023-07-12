package com.woorifisa.seminar.dto.estimation.otherEstimation.response;

import com.woorifisa.seminar.dto.estimation.EstimationResponse;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OtherEstimationItemResponse {

    private final List<EstimationResponse> items;

}
