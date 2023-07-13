package com.woorifisa.seminar.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="classes")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Clazz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="class_no")
	private Long id;
	
	@Column(nullable = false, length = 20)
	private String name;

	@OneToMany(mappedBy = "clazz")
	private List<SeminarType> seminarTypes = new ArrayList<>();
  
}
