package com.my.tsbw.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	private final QuestionRepository questionRepository;

	// 1. 질문 목록 가져오기
	public List<Question> getList() {
		return this.questionRepository.findAll();
	}

	// 2. ID넣어서 일치되는 질문 가져오기
	public Question getQuestionById(Integer id) {
		Optional<Question> q = this.questionRepository.findById(id);
		if (q.isPresent()) {
			return q.get();
		}
		// 일치하는 질문이 없다
		// Exception을 만들어서 던져 보겠다
		// 사용자 정의 예외 클레스 -> 프로젝트별로 별도로 생성 관리 가능
		throw new QuestionNoDateException("해당 ID로는 질무닝 조회되지 않습니다.");
	}
}
