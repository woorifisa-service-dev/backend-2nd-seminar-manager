package com.woorifisa.seminar.entity;

import com.woorifisa.seminar.entity.constant.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="roles")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_no")
	private Long id;
	
	@Column(nullable = false, length = 10)
	@Enumerated(value = EnumType.STRING)
	private Type name;

}
