package com.woorifisa.seminar.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import com.woorifisa.seminar.dto.result.MemberIdAndName;
import com.woorifisa.seminar.dto.result.ResultInfoResponse;
import com.woorifisa.seminar.entity.Subject;
import com.woorifisa.seminar.entity.Team;
import com.woorifisa.seminar.repository.SubjectRepository;
import com.woorifisa.seminar.repository.TeamRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final TeamRepository teamRepository;

    public List<ResultInfoResponse> retrieveTop3Information(final Long classId, final Long seminarTypeId) {
        List<Long> top3Ids = subjectRepository.findTop3Id(classId, seminarTypeId, PageRequest.of(0, 3));

        List<Team> teams = teamRepository.findTop3Teams(top3Ids);
        Map<String, List<Team>> groupedMemberBySubjectName = teams.stream()
                                               .collect(groupingBy(t -> t.getSubject().getTitle()));

        List<ResultInfoResponse> respList = new ArrayList<>();

        for (String key : groupedMemberBySubjectName.keySet()) {

            Team t = groupedMemberBySubjectName.get(key).get(0);
            Subject s = t.getSubject();
            List<MemberIdAndName> memberList = groupedMemberBySubjectName.get(key)
                                                      .stream()
                                                      .map(Team::getMember)
                                                      .map(m -> new MemberIdAndName(m.getId(), m.getName()))
                                                      .collect(toList());

            ResultInfoResponse resp = ResultInfoResponse.builder()
                                                          .clazzName(t.getMember().getClazz().getName())
                                                          .seminarTypeName(key)
                                                          .subjectId(s.getId())
                                                          .subjectTitle(s.getSeminarType().getName())
                                                          .subjectOrder(s.getOrder())
                                                          .memberList(memberList)
                                                          .build();

            respList.add(resp);
        }

        return respList;
    }

}
