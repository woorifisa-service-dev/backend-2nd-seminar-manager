package com.woorifisa.seminar.service;

import com.woorifisa.seminar.dto.MemberInfo;
import com.woorifisa.seminar.dto.estimation.EstimationRequest;
import com.woorifisa.seminar.dto.estimation.EstimationResponse;
import com.woorifisa.seminar.entity.EstimationItem;
import com.woorifisa.seminar.entity.Member;
import com.woorifisa.seminar.entity.Subject;
import com.woorifisa.seminar.entity.TeamEstimation;
import com.woorifisa.seminar.entity.TeamEstimationItem;
import com.woorifisa.seminar.entity.constant.EvaluationArea;
import com.woorifisa.seminar.repository.EstimationItemRepository;
import com.woorifisa.seminar.repository.MemberRepository;
import com.woorifisa.seminar.repository.SubjectRepository;
import com.woorifisa.seminar.repository.TeamEstimationItemRepository;
import com.woorifisa.seminar.repository.TeamEstimationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SelfEstimationService {

    private final EstimationItemRepository estimationItemRepository;
    private final MemberRepository memberRepository;
    private final SubjectRepository subjectRepository;
    private final TeamEstimationRepository teamEstimationRepository;
    private final TeamEstimationItemRepository teamEstimationItemRepository;

    public List<EstimationResponse> findEstimationItems() {

        return estimationItemRepository.findEstimationItemsByEvaluationAreaOrderByOrder(EvaluationArea.자체참여도)
                                       .stream()
                                       .map(EstimationResponse::from)
                                       .collect(Collectors.toList());
    }

    @Transactional
    public List<EstimationResponse> estimateTeam(final Long targetMemberId, final Long subjectId,
                                                 final MemberInfo memberInfo,
                                                 final List<EstimationRequest> estimations) {
        Member member = memberRepository.findById(memberInfo.getId()).orElseThrow();
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();

        TeamEstimation savedTeamEstimation =
            teamEstimationRepository.save(new TeamEstimation(subject, member, targetMemberId));
        List<EstimationResponse> result = new ArrayList<>();

        for (EstimationRequest el : estimations) {
            EstimationItem estimationItem = estimationItemRepository.findById(el.getId()).orElseThrow();
            result.add(new EstimationResponse(estimationItem.getId(), estimationItem.getTitle(), el.getScore()));

            teamEstimationItemRepository.save(new TeamEstimationItem(estimationItem, savedTeamEstimation, el.getScore()));
        }

        return result;
    }

}
