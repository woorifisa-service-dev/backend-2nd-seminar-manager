package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.dto.subject.Top3Result;
import com.woorifisa.seminar.entity.SeminarType;
import com.woorifisa.seminar.entity.Subject;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findBySeminarTypeOrderByOrder(SeminarType targetSeminar);

    @Query(
        "SELECT " +
            "new com.woorifisa.seminar.dto.subject.Top3Result(s.id, s.title, SUM(oei.score)) " +

            "FROM " +
            "OtherEstimationItem oei" +
            " JOIN oei.otherEstimation oe " +
            " JOIN oei.otherEstimation.subject s " +
            " JOIN oei.estimationItem ei " +
            " JOIN s.seminarType.clazz c " +

            "WHERE" +
            " c.id = :classId" +
            " AND s.seminarType.id = :seminarTypeId " +

            "GROUP BY oe.id " +
            "ORDER BY SUM(oei.score) DESC"
    )
    List<Top3Result> findTop3(Long classId, Long seminarTypeId, Pageable pageable);

    @Query(
        "SELECT s.id " +

            "FROM " +
            "OtherEstimationItem oei " +
            " JOIN oei.otherEstimation oe " +
            " JOIN oei.otherEstimation.subject s " +
            " JOIN oei.estimationItem ei " +
            " JOIN s.seminarType.clazz c " +

            "WHERE " +
            " c.id = :classId" +
            " AND s.seminarType.id = :seminarTypeId " +

            "GROUP BY s.id "
    )
    List<Long> findTop3Id(Long classId, Long seminarTypeId, Pageable pageable);

}
