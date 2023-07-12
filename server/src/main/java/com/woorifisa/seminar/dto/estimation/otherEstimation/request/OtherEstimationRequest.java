package com.woorifisa.seminar.dto.estimation.otherEstimation.request;

import com.woorifisa.seminar.dto.estimation.EstimationRequest;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class OtherEstimationRequest {

    @NotNull
    private List<EstimationRequest> estimationRequestList;

}
