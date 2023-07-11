package com.woorifisa.seminar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column
	private String name;
	
	
}
