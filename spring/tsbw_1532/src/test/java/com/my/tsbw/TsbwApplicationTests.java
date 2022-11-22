package com.my.tsbw;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TsbwApplicationTests {
	// JPA 레포포지토리를 이용하여 일종의 쿼리수행 진행 -> 해당객체 필요
	// 어노테이션 기능을 활용하여 객체를 주입하는 형태로 진행
	@Autowired
	private QuestionRepository questionRepository; 
	
	@Test
	void contextLoads() {
	}
	
	/**
	 * 질문테이블 관련 테스팅
	 */
	@Test
	void test_Question_Insert() {
		// 테이블에 데이터 집어 넣기 => 회원가입, 글등록,... 
		Question q = new Question(); // 1. 테이블에 1대1로 대응하는 엔티티객체생성
		q.setSubject("점심은 맛있나요?");
		q.setContent("지하 식당의 메뉴는 잘 나오고 있어요..");
		q.setCreateDate(LocalDateTime.now());
		// 등록
		this.questionRepository.save(q);
		
		q = new Question(); // 1. 테이블에 1대1로 대응하는 엔티티객체생성
		q.setSubject("스프링부트는 어떤가요?");
		q.setContent("세팅이 많습니다.");
		q.setCreateDate(LocalDateTime.now());
		// 등록
		this.questionRepository.save(q);
		/*
		 * 	실제 쿼리
			INSERT INTO Question 
				(subject, content, CREATE_DATE) 
			values 
				('스프링부트는 어떤가요?', '세팅이 많습니다.', now() );
		*/
	}
	/**
	 * 답변테이블 관련 테스팅
	 */
}
