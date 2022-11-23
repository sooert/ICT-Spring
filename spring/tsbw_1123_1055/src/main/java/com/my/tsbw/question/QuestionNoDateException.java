package com.my.tsbw.question;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 실제로는 -> 해당 페이지가 없다
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="id not found")
public class QuestionNoDateException extends RuntimeException {
	public QuestionNoDateException(String msg) {
		super(msg);
	}
}
