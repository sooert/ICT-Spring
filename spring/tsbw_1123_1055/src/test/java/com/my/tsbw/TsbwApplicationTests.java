package com.my.tsbw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.my.tsbw.question.Question;
import com.my.tsbw.question.QuestionRepository;

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
	// 질문 테이블에 데이터 넣기 => 질문 등록
	/*
	 * SQL:INSERT INTO `ToDoBoard`.`question` (`subject`, `content`, `create_date`)
	 * VALUES ('제목1', '내용1', '2022-11-23 10:17:57');
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
		 * 실제 쿼리 INSERT INTO Question (subject, content, CREATE_DATE) values ('스프링부트는
		 * 어떤가요?', '세팅이 많습니다.', now() );
		 */
	}

	// 질문 테이블에 있는 모든 데이터를 가져온다
	@Test
	void test_Question_Select() {
		// findAll() : 모든 데이터를 조회하여 가져올때 사용
		// sql : select * from question;
		List<Question> all = this.questionRepository.findAll();
		// assertEquals(기대값, 실제값) => 동일하면 성공
		assertEquals(2, all.size());

	}

	// id값을 넣어서 일치하는 데이터를 가져온다
	@Test
	void test_Question_Select_ID() {
		Optional<Question> q = this.questionRepository.findById(1);
		if (q.isPresent()) {
			Question question = q.get();
			assertEquals("점심은 맛있나요?", question.getSubject());
		}
	}

	// 제목을 넣어서 데이터를 가져온다
	@Test
	void test_Question_Select_subject() {
		// 기본 지원 API가 없다면 -> 커스텀으로 만들어서 처리
		// questionRepository에서 메족으로 검색하는 함수를 선언
//		Optional<Question> q = this.questionRepository.findBySubject("점심");
//		if (q.isPresent()) {
//			Question question = q.get();
//			assertEquals("점심은 맛있나요?", question.getSubject());
//		}
//		// 특정 단어가 포함되어 있다면 가져와라
//		this.questionRepository.findBySubjectLike("점심%");
	}
}
