package com.woorifisa.seminar.dto.estimation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class EstimationRequest {

    private Long id;
    private Integer score;

}
