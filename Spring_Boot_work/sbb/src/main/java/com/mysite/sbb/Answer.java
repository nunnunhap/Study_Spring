package com.mysite.sbb;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

// 엔티티 클래스 : 테이블로 생성. 용도 > 답변 테이블
@Getter
@Setter // 엔티티 만들 때 Setter 메서드 사용하지 않기를 권장함.
@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;

	// Answer 입장에서 Question은 부모임. 참조되는 클래스가 참조하는 클래스 안에 들어와 있어야 함.
	@ManyToOne // N : 1 관계 ==> 많은 Answer 당 Question 하나
	private Question question;
	
}
