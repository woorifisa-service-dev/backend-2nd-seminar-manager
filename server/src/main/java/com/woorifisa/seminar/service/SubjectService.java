package com.woorifisa.seminar.service;

import com.woorifisa.seminar.dto.subject.Top3Result;
import com.woorifisa.seminar.entity.Member;
import com.woorifisa.seminar.repository.MemberRepository;
import com.woorifisa.seminar.repository.SubjectRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final MemberRepository memberRepository;

    public void test(final Long classId, final Long seminarTypeId) {
        List<Top3Result> top3 = subjectRepository.findTop3(classId, seminarTypeId, PageRequest.of(0, 3));
        List<Member> members = memberRepository.findTeamMemberBySubject(List.of(20L, 19L, 21L));

        top3.forEach(System.out::println);
        members.forEach(System.out::println);

    }

}
