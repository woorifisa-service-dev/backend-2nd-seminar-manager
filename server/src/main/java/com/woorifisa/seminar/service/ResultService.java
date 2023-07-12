package com.woorifisa.seminar.service;

import static java.util.stream.Collectors.toList;

import com.woorifisa.seminar.dto.result.ResultInfoResponse;
import com.woorifisa.seminar.entity.Clazz;
import com.woorifisa.seminar.entity.Member;
import com.woorifisa.seminar.entity.SeminarType;
import com.woorifisa.seminar.entity.Subject;
import com.woorifisa.seminar.entity.Team;
import com.woorifisa.seminar.repository.ClassesRepository;
import com.woorifisa.seminar.repository.MemberRepository;
import com.woorifisa.seminar.repository.SeminarTypeRepository;
import com.woorifisa.seminar.repository.SubjectRepository;
import com.woorifisa.seminar.repository.TeamRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ClassesRepository classesRepository;
    private final MemberRepository memberRepository;
    private final SeminarTypeRepository seminarTypeRepository;
    private final SubjectRepository subjectRepository;
    private final TeamRepository teamRepository;

    public List<ResultInfoResponse> getAllResultInfo(Long classId, Long seminarTypeId) {

        Clazz targetClazz = classesRepository.findById(classId).orElseThrow(NoSuchElementException::new);
        SeminarType targetSeminar = seminarTypeRepository.findById(seminarTypeId)
                                                         .orElseThrow(NoSuchElementException::new);

        List<Subject> targetSubjectList = subjectRepository.findBySeminarTypeOrderByOrder(targetSeminar);

        List<ResultInfoResponse> targetInfos = new ArrayList<>();
        for (Subject ts : targetSubjectList) {
            List<String> targetmemberNameList = teamRepository.findBySubjectId(ts.getId())
                                                              .stream()
                                                              .map(Team::getMember) // -> team.getMember()
                                                              .map(Member::getName) // member -> member.getName()
                                                              .collect(toList());

            targetInfos.add(ResultInfoResponse.from(targetClazz.getName(), targetSeminar.getName(), ts.getTitle(),
                ts.getOrder(), targetmemberNameList));
        }

        return targetInfos;
    }
}
