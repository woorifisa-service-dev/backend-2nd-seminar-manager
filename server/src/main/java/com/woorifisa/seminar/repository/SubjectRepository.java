package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
