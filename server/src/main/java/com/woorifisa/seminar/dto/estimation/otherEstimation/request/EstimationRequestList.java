package com.woorifisa.seminar.dto.estimation.otherEstimation.request;

import com.woorifisa.seminar.dto.estimation.EstimationRequest;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class EstimationRequestList {

    private List<EstimationRequest> data;

}
