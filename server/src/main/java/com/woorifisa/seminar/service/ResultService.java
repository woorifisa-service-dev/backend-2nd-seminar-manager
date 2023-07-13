package com.woorifisa.seminar.service;

import static java.util.stream.Collectors.toList;

import com.woorifisa.seminar.dto.result.ResultInfoResponse;
import com.woorifisa.seminar.dto.result.ResultScoreResponse;
import com.woorifisa.seminar.entity.Clazz;
import com.woorifisa.seminar.entity.Member;
import com.woorifisa.seminar.entity.OtherEstimation;
import com.woorifisa.seminar.entity.SeminarType;
import com.woorifisa.seminar.entity.Subject;
import com.woorifisa.seminar.entity.Team;
import com.woorifisa.seminar.entity.TeamEstimation;
import com.woorifisa.seminar.entity.constant.Type;
import com.woorifisa.seminar.exception.notfound.ClassNotFoundException;
import com.woorifisa.seminar.exception.notfound.SeminarTypeNotFoundException;
import com.woorifisa.seminar.repository.ClassesRepository;
import com.woorifisa.seminar.repository.MemberRepository;
import com.woorifisa.seminar.repository.OtherEstimationItemRepository;
import com.woorifisa.seminar.repository.OtherEstimationRepository;
import com.woorifisa.seminar.repository.SeminarTypeRepository;
import com.woorifisa.seminar.repository.SubjectRepository;
import com.woorifisa.seminar.repository.TeamEstimationItemRepository;
import com.woorifisa.seminar.repository.TeamEstimationRepository;
import com.woorifisa.seminar.repository.TeamRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultService {

	private final ClassesRepository classesRepository;
//    private final MemberRepository memberRepository;
	private final SeminarTypeRepository seminarTypeRepository;
	private final SubjectRepository subjectRepository;
	private final TeamRepository teamRepository;

	private final OtherEstimationRepository otherEstimationRepository;
	private final OtherEstimationItemRepository otherEstimationItemRepository;
	private final TeamEstimationRepository teamEstimationRepository;
	private final TeamEstimationItemRepository teamEstimationItemRepository;
	
	public List<ResultInfoResponse> getAllResultInfo(Long classId, Long seminarTypeId) {

		Clazz targetClazz = classesRepository.findById(classId).orElseThrow(ClassNotFoundException::new);
		SeminarType targetSeminar = seminarTypeRepository.findById(seminarTypeId)
				.orElseThrow(SeminarTypeNotFoundException::new);

		List<Subject> targetSubjectList = subjectRepository.findBySeminarTypeOrderByOrder(targetSeminar);

		List<ResultInfoResponse> targetInfos = new ArrayList<>();
		for (Subject ts : targetSubjectList) {
			List<Long> targetmemberIdList = teamRepository.findBySubjectId(ts.getId()).stream().map(Team::getMember) // team
					// ->
					// team.getMember()
					.map(Member::getId) // member -> member.getName()
					.collect(toList());
			List<String> targetmemberNameList = teamRepository.findBySubjectId(ts.getId()).stream().map(Team::getMember) // team
																															// ->
																															// team.getMember()
					.map(Member::getName) // member -> member.getName()
					.collect(toList());

			targetInfos.add(ResultInfoResponse.from(targetClazz.getName(), targetSeminar.getName(), ts.getId(),
					ts.getTitle(), ts.getOrder(), targetmemberIdList, targetmemberNameList));
		}

		return targetInfos;
	}
	
	public ResultScoreResponse getScoreByUser(Long sessionUserId, Long subjectId) {
		Subject targetSubject = subjectRepository.findById(subjectId).orElseThrow(NoSuchElementException::new);

		List<Long> targetOtherEstimation = otherEstimationRepository.findBySubject(targetSubject).stream()
				.map(OtherEstimation::getId).collect(Collectors.toList());

		Long targetTeacherScore = otherEstimationItemRepository.targetScore(targetOtherEstimation, Type.TEACHER);
		Long targetMentorScore = otherEstimationItemRepository.targetScore(targetOtherEstimation, Type.MENTOR);
		Long targetStudentScore = otherEstimationItemRepository.targetScore(targetOtherEstimation, Type.STUDENT);

		Long targetTotalScore = targetTeacherScore + targetMentorScore + targetStudentScore;
		//내부 평가
		List<Long> targeteamEstimation = teamEstimationRepository.findByIdAndSubjectId(sessionUserId, subjectId);

		List<Long> targetTeamMemberScore = teamEstimationItemRepository.targetScore(targeteamEstimation);

		Long targetTeamMemberTotalScore = targetTeamMemberScore.stream().mapToLong(Long::longValue).sum();
		Double targetTeamMemberAvgScore = (double) (targetTeamMemberTotalScore / targeteamEstimation.size());


		return ResultScoreResponse.from(targetTeacherScore, targetMentorScore, targetStudentScore, targetTotalScore, targetTeamMemberTotalScore, targetTeamMemberAvgScore);
	}

}
