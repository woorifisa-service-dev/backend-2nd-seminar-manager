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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="member_no")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "role_no", nullable = false)
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "class_no", nullable = false)
	private Clazz clazz;
	
	@Column(nullable = false, length = 20)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	@Column(nullable = false, length = 10)
	private String name;
	
	@Column(name="created_at", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createdAt;
}
