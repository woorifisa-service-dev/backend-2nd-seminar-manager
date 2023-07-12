package com.woorifisa.seminar.service;

import static com.woorifisa.seminar.entity.constant.EvaluationArea.기술성;
import static com.woorifisa.seminar.entity.constant.EvaluationArea.발표력;
import static com.woorifisa.seminar.entity.constant.EvaluationArea.참여도;
import static java.util.stream.Collectors.toList;

import com.woorifisa.seminar.dto.MemberInfo;
import com.woorifisa.seminar.dto.estimation.EstimationRequest;
import com.woorifisa.seminar.dto.estimation.EstimationResponse;
import com.woorifisa.seminar.entity.EstimationItem;
import com.woorifisa.seminar.entity.Member;
import com.woorifisa.seminar.entity.OtherEstimation;
import com.woorifisa.seminar.entity.OtherEstimationItem;
import com.woorifisa.seminar.entity.Subject;
import com.woorifisa.seminar.entity.constant.EvaluationArea;
import com.woorifisa.seminar.entity.constant.Type;
import com.woorifisa.seminar.repository.EstimationItemRepository;
import com.woorifisa.seminar.repository.MemberRepository;
import com.woorifisa.seminar.repository.OtherEstimationItemRepository;
import com.woorifisa.seminar.repository.OtherEstimationRepository;
import com.woorifisa.seminar.repository.SubjectRepository;
import java.util.ArrayList;
import java.util.List;
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

    public List<EstimationResponse> findEstimationItems(Type type) {
        if (type == Type.STUDENT) {
            return findEstimationItemsForValuer(List.of(발표력));
        } else if (type == Type.MENTOR) {
            return findEstimationItemsForValuer(List.of(발표력, 기술성));
        } else if (type == Type.TEACHER) {
            return findEstimationItemsForValuer(List.of(발표력, 기술성, 참여도));
        } else {
            throw new IllegalArgumentException();
        }
    }

    private List<EstimationResponse> findEstimationItemsForValuer(List<EvaluationArea> evaluationAreas) {
        return estimationItemRepository.findEstimationItemsByEvaluationAreaInOrderByOrder(evaluationAreas)
                                       .stream()
                                       .map(EstimationResponse::from)
                                       .collect(toList());
    }

    @Transactional
    public List<EstimationResponse> estimateOtherTeamByStudent(final Long subjectId, final MemberInfo memberInfo,
                                                               final List<EstimationRequest> estimations) {

        Member member = memberRepository.findById(memberInfo.getId()).orElseThrow();
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();
        OtherEstimation savedOe = otherEstimationRepository.save(new OtherEstimation(member, subject));

        List<EstimationResponse> items = new ArrayList<>();
        for (EstimationRequest eReq : estimations) {
            EstimationItem foundEi = estimationItemRepository.findById(eReq.getId())
                                                             .orElseThrow();

            items.add(new EstimationResponse(foundEi.getId(), foundEi.getTitle(), eReq.getScore()));

            OtherEstimationItem oi = new OtherEstimationItem(foundEi, savedOe, eReq.getScore(), memberInfo.getRole());
            otherEstimationItemRepository.save(oi);
        }

        return items;
    }

}
