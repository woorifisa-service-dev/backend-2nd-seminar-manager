package com.woorifisa.seminar.service;

import static java.util.stream.Collectors.toList;

import com.woorifisa.seminar.dto.MemberInfo;
import com.woorifisa.seminar.dto.estimation.EstimationRequest;
import com.woorifisa.seminar.dto.estimation.EstimationResponse;
import com.woorifisa.seminar.dto.estimation.otherEstimation.request.OtherEstimationRequest;
import com.woorifisa.seminar.entity.EstimationItem;
import com.woorifisa.seminar.entity.Member;
import com.woorifisa.seminar.entity.OtherEstimation;
import com.woorifisa.seminar.entity.OtherEstimationItem;
import com.woorifisa.seminar.entity.Subject;
import com.woorifisa.seminar.entity.constant.EvaluationArea;
import com.woorifisa.seminar.repository.EstimationItemRepository;
import com.woorifisa.seminar.repository.MemberRepository;
import com.woorifisa.seminar.repository.OtherEstimationItemRepository;
import com.woorifisa.seminar.repository.OtherEstimationRepository;
import com.woorifisa.seminar.repository.SubjectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OtherEstimationService {

    private final EstimationItemRepository estimationItemRepository;
    private final MemberRepository memberRepository;
    private final SubjectRepository subjectRepository;
    private final OtherEstimationRepository otherEstimationRepository;
    private final OtherEstimationItemRepository otherEstimationItemRepository;

    public List<EstimationResponse> findEstimationItems() {

        return estimationItemRepository.findEstimationItemsByEvaluationAreaOrderByOrder(EvaluationArea.참여도)
                                       .stream()
                                       .map(EstimationResponse::from)
                                       .collect(toList());
    }

    @Transactional
    public List<EstimationResponse> estimateOtherTeamByStudent(final Long subjectId, final MemberInfo memberInfo,
                                                               final OtherEstimationRequest otherEstimationRequest) {

        Member member = memberRepository.findById(memberInfo.getId()).orElseThrow();
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();
        OtherEstimation savedOe = otherEstimationRepository.save(new OtherEstimation(member, subject));

        List<EstimationRequest> estimations = otherEstimationRequest.getEstimationRequestList();

        List<EstimationResponse> items = new ArrayList<>();
        for (EstimationRequest eReq : estimations) {
            EstimationItem foundEi = estimationItemRepository.findById(eReq.getId())
                                                             .orElseThrow();
            items.add(EstimationResponse.from(foundEi));

            OtherEstimationItem oi = new OtherEstimationItem(foundEi, savedOe, eReq.getScore());
            otherEstimationItemRepository.save(oi);
        }

        return items;
    }

}
