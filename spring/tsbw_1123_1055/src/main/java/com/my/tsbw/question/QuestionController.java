package com.my.tsbw.question;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {
	private final QuestionService questionService;

	@RequestMapping("/question/todoList")
	public String todoList(Model model) {
		List<Question> all = this.questionService.getList();
		model.addAttribute("questions", all);
		return "question_view";
	}
	@RequestMapping("/question/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id){
		// 최종 데이터를 Question(엔티티)로 받는 부분이 다소 보안성에 위배될 수 있다
		// setXXX가 있어서 -> DT0로 대체하라(권장)
		Question q = this.questionService.getQuestionById(id);
		model.addAttribute("question", q);
		return "question_detail";
	}
}
