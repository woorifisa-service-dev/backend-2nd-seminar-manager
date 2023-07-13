package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.entity.SeminarType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeminarTypeRepository extends JpaRepository<SeminarType, Long> {

    @Query("SELECT st FROM SeminarType st RIGHT OUTER JOIN FETCH st.clazz")
    List<SeminarType> findAllByClassId();

}
