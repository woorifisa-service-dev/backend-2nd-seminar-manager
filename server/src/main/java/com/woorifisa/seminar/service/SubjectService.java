package com.woorifisa.seminar.service;

import static java.util.stream.Collectors.*;

import com.woorifisa.seminar.dto.subject.Top3Result;
import com.woorifisa.seminar.entity.Member;
import com.woorifisa.seminar.entity.Team;
import com.woorifisa.seminar.repository.MemberRepository;
import com.woorifisa.seminar.repository.SubjectRepository;
import com.woorifisa.seminar.repository.TeamRepository;
import java.util.List;
import java.util.stream.Collectors;
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

    public void test(final Long classId, final Long seminarTypeId) {
        List<Top3Result> top3 = subjectRepository.findTop3(classId, seminarTypeId, PageRequest.of(0, 3));
        List<Team> teams = teamRepository.findMemberBySubject(top3.stream().map(Top3Result::getSubjectId).collect(toList()));

        // teams.stream()
        //          .g
        //
        // top3.forEach(System.out::println);
        // members.forEach(System.out::println);

    }

}
