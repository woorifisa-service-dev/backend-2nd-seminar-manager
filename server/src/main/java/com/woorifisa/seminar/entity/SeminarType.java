package com.woorifisa.seminar.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seminar_types")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SeminarType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seminar_type_no")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_no", nullable = false)
    private Clazz clazz;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private LocalDate beginDate;

    @Column(nullable = false)
    private LocalDate endDate;

}
