package com.my.tsbw;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Answer 엔티티 역활 담당
 * @author Administrator
 *
 */
@Getter
@Setter
@Entity
public class Answer {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column( columnDefinition = "TEXT" )
	private String content;

	private LocalDateTime createDate;
	
	// 질문 한개에 답변은 여러개가 생성될수 있다
	// 질문(One) 답변(Many)
	// @ManyToOne : N:1  @OneToMany 1:N
	// 답변 관점에서는 M->O
	// 데이터베이스 ForeignKey 관계
	// 질문 하나를 삭제하면 그 질문에 부속된 답변들이 다 같이 삭제된다
	// 디비상에 컬럼명은 속성명_ID  추가
	@ManyToOne
	private Question question;
	
}






